import kotlin.collections.ArrayList

//creating class of bubble sorting
class BubbleSortAlgorithm {
    //creating function of bubble sorting

    fun bubbleSorting(lines: ArrayList<String>){

        var tem:String

        //first pass by iterating through all the index number of array
        for(j in lines.indices){

            //second pass by iterating  next current index number until the size of array
            for (i in j+1 until lines.size){

                //comparing the current value with the next  value.
                //The algorithm will be looping as long as  (next value < current value) is true.
                //it compares two  elements' uppercase value
                if (lines[i].uppercase().filter { !it.isWhitespace()}< lines[j].uppercase().filter { !it.isWhitespace()}){

                    //temporarily storing the current value
                    tem = lines[j]

                    //replace current value to the next current value
                    lines[j] = lines[i]

                    //next value will be stored temporarily to tem variable
                    lines[i] = tem

                    //loop again  to the  next comparison for 2nd pass
                }

                //if 2nd pass is completed, go for the next index number of first pass.
            }

            //loop again  to the 2nd pass then 3rd and so forth to the last indices of ArrayList
        }

    }
}

