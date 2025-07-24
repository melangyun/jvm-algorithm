package boj.dp

/*
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다.
N은 40보다 작거나 같은 자연수 또는 0이다.

각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

예제 입력 1
3
0
1
3

예제 출력 1
1 0
0 1
1 2

예제 입력 2
2
6
22

예제 출력 2
5 8
10946 17711
*/
class BOJ1003 {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val dp = Array<Pair<Int, Int>>(41) { Pair(0, 0) };

        val answer = StringBuilder()
        dp[0] = Pair(1, 0)
        dp[1] = Pair(0, 1)
        var top = 2

        repeat(br.readLine().toInt()) {
            val target = br.readLine().toInt()
            if (target >= 2) {
                for (i in top..target) {
                    dp[i] = Pair(
                        dp[i - 1].first + dp[i - 2].first,
                        dp[i - 1].second + dp[i - 2].second
                    )
                }
                top = target
            }
            answer.append("${dp[target].first} ${dp[target].second}\n")
        }
        println(answer)
    }
}