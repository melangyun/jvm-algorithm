package boj.queue

/*
첫째 줄에 N과 K가 주어진다. (3 ≤ N ≤ 300,000, 1 ≤ K ≤ N)
다음 N개 줄에는 상근이네 반 학생의 이름이 성적순으로 주어진다.

이름은 알파벳 대문자로 이루어져 있고, 2글자 ~ 20글자이다.

모든 학생은 자신과 반 등수의 차이가 K를 넘으면 친구가 아니다.
진정한 친구는 이름의 길이가 같아야 한다.

진정한 친구가 몇 쌍인지 구하는 프로그램을 작성하시오.
*/
class BOJ3078 {
    // 시간초과
    fun solution() {
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map(String::toInt)
        val students = arrayOfNulls<String>(n).map { br.readLine() }
        var answer = 0;
        for (i in 0..n - k) {
            for (j in i + 1..i + k) {
                if (j >= n) continue
                if (students[i].length == students[j].length) {
                    answer++;
                }
            }
        }
        print(answer)
    }


    fun solution2() {
        val br = System.`in`.bufferedReader()
        val (n, k) = br.readLine().split(" ").map(String::toInt)

        var answer = 0L;
        val queues = Array<MutableList<Int>>(21) { mutableListOf() }

        for(i in 0 until n){
            val nameLength = br.readLine().length
            val queue = queues[nameLength]
            while (queue.isNotEmpty() && i - queue.first() > k) {
                queue.removeFirst()
            }
            answer += queue.size
            queue.add(i)
        }
        print(answer)
    }
}