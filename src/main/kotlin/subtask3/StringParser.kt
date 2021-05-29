package subtask3

class StringParser {
    private val result = mutableListOf<String>()
    private val substringsOrder = mutableListOf<Pair<Int, IntRange>>()
    private val openings = mutableListOf<Pair<Char, Int>>()

    fun getResult(inputString: String): Array<String> {

        inputString.forEachIndexed { index, char ->
            when (char) {
                '(', '[', '<' -> {
                    openings.add(char to index)
                }
                ')' -> {
                    openings.apply {
                        val element = lastOrNull { it.first == ')' }
                        val orderNumber: Int
                        if (element != null) {
                            orderNumber = this.lastIndexOf(element)
                            substringsOrder.add(orderNumber to (element.second - 1)..index)
                        }

                    }
                }
                ']' -> {
                    openings.apply {
                        val element = lastOrNull { it.first == ']' }
                        val orderNumber: Int
                        if (element != null) {
                            orderNumber = this.lastIndexOf(element)
                            substringsOrder.add(orderNumber to (element.second - 1)..index)
                        }

                    }
                }
                '>' -> {
                    openings.apply {
                        val element = lastOrNull { it.first == '>' }
                        val orderNumber: Int
                        if (element != null) {
                            orderNumber = this.lastIndexOf(element)
                            substringsOrder.add(orderNumber to (element.second - 1)..index)
                        }
                    }
                }
            }
        }

        return arrayOf()
    }

}