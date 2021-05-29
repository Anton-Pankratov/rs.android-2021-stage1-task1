package subtask2

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        ( bill.sumBy { if (it != bill[k]) it else 0 } / 2 ).apply {
            return when (b) {
                this -> "Bon Appetit"
                else -> "${b - this}"
            }
        }
    }
}
