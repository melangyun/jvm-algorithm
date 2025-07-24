package boj.dp

import java.io.*

class BOJ2302 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val N = br.readLine().toInt() // 좌석의 갯수 1 <= N <= 40
        val M = br.readLine().toInt() // M은 0 이상 N 이하

        val dp = IntArray(41)
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        for (i in 3..40) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        var answer = 1L
        var start = 0

        repeat(M) {
            val end = br.readLine().toInt()
            answer *= dp[end - start - 1]
            start = end
        }
        answer *= dp[N - start]

        println(answer)
    }
}