package bfs

import java.io.*
import java.util.LinkedList


data class Node(
    val x: Int,
    val y: Int,
    val crashed: Int,
    val distance: Int,
)

class BOJ14442 {
    fun solution(br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))): Int {
        val (N, M, K) = br.readLine().split(" ").map(String::toInt)
        val map = Array<CharArray>(N) { br.readLine().toCharArray() }
        val visit = Array<Array<BooleanArray>>(K + 1) { Array<BooleanArray>(N) { BooleanArray(M) } }


        val dxy = arrayOf(intArrayOf(1, 0, -1, 0), intArrayOf(0, 1, 0, -1))
        val queue = LinkedList<Node>()

        queue.add(Node(0, 0, 0, 1))
        visit[0][0][0] = true


        while (queue.isNotEmpty()) {
            val (x, y, crashed, distance) = queue.poll()

            if (x == N - 1 && y == M - 1) return distance

            for (i in 0 until 4) {
                val nx = x + dxy[0][i];
                val ny = y + dxy[1][i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visit[crashed][nx][ny]) continue;

                if (map[nx][ny] == '1' && crashed < K &&
                    (crashed == 0 || !visit[crashed - 1][nx][ny])
                ) {
                    queue.add(Node(nx, ny, crashed + 1, distance + 1))
                    visit[crashed + 1][nx][ny] = true
                } else if (map[nx][ny] == '0') {
                    queue.add(Node(nx, ny, crashed, distance + 1))
                    visit[crashed][nx][ny] = true
                }
            }
        }

        return -1
    }
}