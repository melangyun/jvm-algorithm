package boj.dp

import java.io.*
import java.util.StringTokenizer
import kotlin.math.max

class BOJ14501 {
    fun solution(br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))): Int {
        val n = br.readLine().toInt()
        val costs = IntArray(n)
        val profits = IntArray(n)
        val dp = IntArray(n + 1)

        repeat(n) {
            val st = StringTokenizer(br.readLine())
            costs[it] = st.nextToken().toInt()
            profits[it] = st.nextToken().toInt()
        }

        for (i in 0 until n) {
            var day = i + costs[i]
            while (day <= n) {
                dp[day] = max(dp[day], dp[i] + profits[i])
                day++
            }
        }
        return dp.max()
    }
}