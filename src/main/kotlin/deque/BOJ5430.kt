package deque

/*
선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다.
AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다.
배열이 비어있는데 HL D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다.
예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다.
예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

예제 입력
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]

예제 출력
[2,1]
error
[1,2,3,5,8]
error
*/
class BOJ5430 {

    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private fun calculate() {
        val commands = br.readLine().replace("RR", "")
        val cnt = br.readLine().toIntOrNull() ?: 0
        val deque: MutableList<String> = br.readLine().drop(1).dropLast(1)
            .split(",").toMutableList()

        if (commands.count { it == 'D' } > cnt) {
            bw.write("error\n")
            return
        }

        var isReversed = false;
        commands.forEach {
            when (it) {
                'R' -> isReversed = !isReversed
                'D' -> {
                    if (isReversed) {
                        deque.removeLast()
                    } else {
                        deque.removeFirst()
                    }
                }

            }
        }

        if (!isReversed) {
            bw.write(deque.joinToString(",", "[", "]") + "\n")
        } else {
            bw.write(deque.reversed().joinToString(",", "[", "]") + "\n")
        }
    }

    fun solution() {
        repeat(br.readLine().toInt()) { this.calculate() }
        bw.close()
    }
}
