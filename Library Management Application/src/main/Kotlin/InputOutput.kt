import java.io.*

class InputOutput {

    //Reading  and writing  text file using java.io package of java

    fun readFile():ArrayList<String>{
        val lines = ArrayList<String>() // Creating an empty array
        val reader: BufferedReader?
        reader = BufferedReader(FileReader("data.txt")) // Read a stream of characters from the text file
        var currentLine = reader.readLine() // Read the characters line by line

        while (currentLine != null) {
            lines.add(currentLine)         // storing  each line as an element in an array
            currentLine = reader.readLine()

        }
        reader.close()                // close the file output stream and releases all system resources

        lines.removeAt(0)     // remove title of the array
        return lines
    }

    fun writeFile(args: List<String>){
        val writer: BufferedWriter?
        writer = BufferedWriter(FileWriter("Sorted.txt")) // Write a stream of characters from the sorted array

        writer.write("Title, Author(s), Publisher, Subject, Publishing Date\n")
        for (line in args) {
            writer.write(line) // Write each element of sorted array to a new text file
            writer.newLine()  // jump to a new  line after writing each element

        }
        try {

            writer.close()  // close output stream
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}