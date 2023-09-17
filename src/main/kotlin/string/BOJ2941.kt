package string

class BOJ2941 {
    fun solution() {
        val word = readLine()!!
        val replacedCnt = arrayOf(
            "c=",
            "c-",
            "dz=",
            "d-",
            "lj",
            "nj",
            "s=",
            "z="
        ).fold(0) { acc, s -> acc + word.split(s).size - 1 }
        println(word.length - replacedCnt)
    }
}