package dp

/*
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
둘째 줄에는 N개의 수가 주어진다.
수는 1,000보다 작거나 같은 자연수이다.

셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N

5 3
5 4 3 2 1
1 3
2 4
5 5

12
9
1
*/

class BOJ11659 {

    private val br = System.`in`.bufferedReader()

    private fun readToInts(): List<Int> {
        return this.br.readLine()
            .split(" ")
            .map(String::toInt)
    }

    fun solution() {
        // prefixsum의 시간을 줄이는 기법중 하나임(dp)
        val (NUM_CNT, CALCULATION_CNT) = readToInts()
        val numbers = readToInts()
        val dp = IntArray(NUM_CNT + 1)
        dp[0] = 0
        for (i in 1..NUM_CNT) {
            dp[i] = dp[i - 1] + numbers[i - 1]
        }

        val answer = StringBuilder()
        /*
        D[i] = A[1] + A[2] + ... + A[i]
        D[i] = D[i-1] + A[i]

        A[i] + ... + A[j]
        => D[j]-D[i-1]
        */
        repeat(CALCULATION_CNT) {
            val (start, end) = readToInts()
            answer.append(dp[end] - dp[start - 1]).append("\n")
        }
        println(answer)
    }
}