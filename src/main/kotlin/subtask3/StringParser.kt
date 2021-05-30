package subtask3

/**
 * [substringsOrder] - list of found substrings with order for future parsing in [result].
 * Represent by [MutableList] of [Pair], where 'first' is a order number in [result] and 'second'
 * is [IntRange] of [substring] in "inputString" of [getResult].
 *
 * [openings] - list of found opening brackets in string, where 'first' of [Pair] is bracket char and
 * 'second' is index of "inputString"
 */

class StringParser {
    private val result = mutableListOf<String>()
    private val substringsOrder = mutableListOf<Pair<Int, IntRange>>()
    private val openings = mutableListOf<Pair<Char, Int>>()

    fun getResult(inputString: String): Array<String> {

        inputString.forEachIndexed { index, char ->
            (char to index).apply {
                when (char) {
                    '(', '[', '<' -> openings.add(this)
                    ')' -> '('.formInterBracketsRange(this)
                    ']' -> '['.formInterBracketsRange(this)
                    '>' -> '<'.formInterBracketsRange(this)
                }
            }
        }

        substringsOrder.sortedBy { it.first }.forEach {
            result.add(inputString.substring(it.second))
        }

        return result.toTypedArray()
    }

    private fun Char.formInterBracketsRange(pair: Pair<Char, Int>) {
        openings.apply {
            val element = lastOrNull { it.first == this@formInterBracketsRange }
            val orderNumber: Int
            if (element != null) {
                orderNumber = this.lastIndexOf(element)
                substringsOrder.add(orderNumber to((element.second + 1) until pair.second))
                set(indexOf(element), '*' to -1)
            }
        }
    }
}