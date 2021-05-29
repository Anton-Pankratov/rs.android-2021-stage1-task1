package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var toHappyArray = sadArray.useFilter()
        while (toHappyArray.size != toHappyArray.useFilter().also { toHappyArray = it }.size) {
            continue
        }
        return toHappyArray
    }

    private fun IntArray.useFilter(): IntArray {
        apply {
            return filterIndexed { index, i ->
                index == 0 || index == size - 1 || ((elementAt(index + 1) + elementAt(index - 1)) > i)
            }.toIntArray()
        }
    }
}