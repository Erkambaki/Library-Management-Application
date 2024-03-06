import java.io._
import scala.io._
import scala.util.{Failure, Success, Try}

object RadixSortAlgorithm {

  def Radix(): Unit = {
    // buffering the source file named "data.txt"
     val bookSource = Source.fromFile("data.txt") //U can change Books Source
    // List by parsing into rows
     val data = bookSource.getLines().toList
    // separating the list as "header" and "tail"
    val (header, tail) = (data.head, data.tail)
    //splitting tail with "/" then mapping all tail . and get List of BookExtended
     val book_List = tail.map(l => {
      val split = l.split("/").map(_.strip())
      BookExtended(split(0), split(1), split(2), split(3), split(4))
    })
    bookSource.close()

    //recording the startTime before using the radix method
     val startTime = System.currentTimeMillis()
    // sorts by titles first and then sorts by authors .
    //using nested Radix method named "sortRadixList".
     val bookSorted = sortRadixList[BookExtended](
      //inside method sorts by authors
      sortRadixList[BookExtended](book_List, _.author),
      //outside method sorts by titles
      _.title
    )
    //mapping List of BookExtended named "bookSorted" and converting to List of String as sortBOOKasList
     val sortBOOKasList = bookSorted.map(_.productIterator.mkString("/"))
    //add the header to the list
     val outputTextFile = sortBOOKasList.+:(header)
    //recording the endTime after using the radix method
     val endTime = System.currentTimeMillis()
    //calculating the executionTime for the radix method
     val executionTime = endTime - startTime
    //Print here: time elapsed sort book
    println(s"The execution time for Radix Sorting is : $executionTime milliseconds\n")

    //using printToFile method to output file named "sorted.txt".
    printToFile(new File("sorted.txt")) { p =>
      outputTextFile.map(l => p.println(l))
    }
  }
  //a list that has elements of type T
  //  Radix method named "sortRadixList" that works any types "A"
  //  takes List input parameter that has elements of type any: List[A]  named "listRaw"
  //  and takes "A" parameter  of function returns String  named "columnFunc"
  def sortRadixList[A](listRaw: List[A], columnFunc: A => String): List[A] = {
    // find the longest String of the given column
    val wMax = listRaw.map(l => columnFunc(l).length).max

    // A method named "accLSD" is inner method of : "sortRadixList" method. it is tailRecursive method
    @scala.annotation.tailrec
    def accLSD(listAdj: List[A], chIndex: Int): List[A] = {
      // splitting into long and short Strings in 2 lists using map function
      val listParts = listAdj.partition(l => columnFunc(l).length < chIndex + 1)

      // matching String index
      chIndex match {
        case -1 => listAdj
        case _ => accLSD(listParts._1 ::: listParts._2.map(l => columnFunc(l)(chIndex)).
          // using distinct and sorted func of scala
          distinct.sorted.

          flatMap(ch => listParts._2.filter(fStr => columnFunc(fStr)(chIndex) == ch)), chIndex - 1)
      }
    }
    //starting inner method here, which is tail recursive
    accLSD(listRaw, wMax - 1)
  }
  // printToFile method to write a file
  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit): Unit = {
    // create a new writer
    val p = new java.io.PrintWriter(f)
    Try(op(p)) match {
      case Success(_) => p.close()
      case Failure(exception) => println(s"Got an error $exception")
    }
  }

}