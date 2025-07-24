package boj.stack

/*

첫 번째 줄에 빌딩의 개수 N이 입력된다.(1 ≤ N ≤ 80,000)
두 번째 줄 부터 N+1번째 줄까지 각 빌딩의 높이가 hi 입력된다. (1 ≤ hi ≤ 1,000,000,000)*

6
10
3
7
4
12
2

*/
private typealias Stack<T> = MutableList<T>

private fun <T> Stack<T>.push(item: T) = add(item)
private fun <T> Stack<T>.pop(): T? = removeLastOrNull()
private fun <T> Stack<T>.peek(): T? = lastOrNull()

class BOJ6198 {
    fun solution(): Long {
        val br = System.`in`.bufferedReader()
        val num = br.readLine().toInt()
        val buildings = arrayOfNulls<Long>(num).map { br.readLine().toInt() }

        val stack: Stack<Int> = mutableListOf()
        var answer = 0L

        for(building in buildings) {
            while (stack.isNotEmpty() && stack.peek()!! <= building) {
                stack.pop()
            }
            stack.push(building)
            answer += stack.size - 1
        }

        return answer
    }
}