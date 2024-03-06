class MergeSortAlgorithm {
    /**
     * An implementation of merge sort procedure
     * AveragePerformance = O(n*lg(n)), where lg(n) is a logarithm of n for base 2
     * The function mergeSort() gets a list and splits at the middle into two new lists.
     * This lists will be passed to mergeSort again until there only lists with one item.
     */

    fun mergeSort(list: MutableList<String>): List<String> {

        // making sure the list is not empty
        //If a given list is empty the function will return empty list and will be executed.
        if (list.size <= 1) {
            return list
        }
        //finding the middle index number of the list
        val middle = list.size / 2

        //Returns a view of the portion of this list between the specified fromIndex (inclusive) and toIndex (exclusive)
        // The returned list is backed by this list
        val left = list.subList(0, middle)
        val right = list.subList(middle, list.size)

        // this is a recursive call.
        // firstly  mergeSort function call "merge" function then it will call itself
        // the algorithm will split and sort both halves before merging them.
        //finally it is going to return the sorted list

        return merge(mergeSort(left), mergeSort(right))
    }

    /**
     * Merges two sublist of initial mutableList of list
     * in ascending order.
     * */

    private fun merge(left: List<String>, right: List<String>): List<String> {
        var indexLeft = 0
        var indexRight = 0
        val newList: MutableList<String> = mutableListOf()

        // mergeSort algorithm is “divide and conquer”
        // it is dividing the element until there is only one element or none left
        while (indexLeft < left.count() && indexRight < right.count()) {

            if (left[indexLeft].uppercase().filter { !it.isWhitespace()} <= right[indexRight].uppercase().filter { !it.isWhitespace()}) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }
        return newList

    }
}