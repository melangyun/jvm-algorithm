package boj.string

class BOJ9996 {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        val pattern = br.readLine().replace("*", ".*").toRegex()
        val answer = Array(n) { "DA" }

        for (i in 0 until n) {
            val word = br.readLine()
            if (!pattern.matches(word)) {
                answer[i] = "NE"
            }
        }

        println(answer.joinToString("\n"))
    }
}