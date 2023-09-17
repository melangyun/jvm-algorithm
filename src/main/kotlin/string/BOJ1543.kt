package string

class BOJ1543 {
    fun solution() {
        var word: String = readlnOrNull()!!
        val searchKeyword: String = readlnOrNull()!!

        println(word.split(searchKeyword).size - 1)
    }
}