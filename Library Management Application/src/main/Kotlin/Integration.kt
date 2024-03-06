import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class Integration {

    // Sorting a data by calling bubbleAlgo or mergeAlgo function

    @OptIn(ExperimentalTime::class)
    fun bubbleAlgo() {
        val a = InputOutput()        // Creating an object of InputOutput class
        val array = a.readFile()     // Read the Input file and store in an array by calling readFile function
        val x = BubbleSortAlgorithm() // Creating an object of BubbleSortAlgorithm class

        val time = measureTimedValue {   //measuring time
            x.bubbleSorting(array)       // sorting the array
        }
        a.writeFile(array)// storing the sorted array to a text file

        println("The execution time for Bubble Sorting is: ${time.duration.inWholeMilliseconds} milliseconds")
    }

    @OptIn(ExperimentalTime::class)
    fun mergeAlgo (){

        val a = InputOutput()           // Creating an object of InputOutput class
        val getArray = a.readFile() // Read the Input file and store in an array by calling readFile function

        var sortedArray: ArrayList<String>
        val merge = MergeSortAlgorithm()// Creating an object of mergeSortAlgorithm  class
        val time = measureTimedValue {
            sortedArray = merge.mergeSort(getArray) as ArrayList<String> //sorting the array using mergeSort function
        }
        a.writeFile(sortedArray)// storing the sorted array to txt file

        println("The execution time for Merge Sorting is: ${time.duration.inWholeMilliseconds} milliseconds")

    }
}