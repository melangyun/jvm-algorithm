package dp

class BOJ11057 {
    fun solution() {
        val N = readln().toInt()
        val dp = Array<IntArray>(1_001) { IntArray(10) }
        for (i in 0..9) {
            dp[1][i] = 1
        }

        for (i in 2..N) {
            for (j in 0..9) {
                for (k in 0..j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10_007
                }
            }
        }
        println(dp[N].sum() % 10_007)
    }
}