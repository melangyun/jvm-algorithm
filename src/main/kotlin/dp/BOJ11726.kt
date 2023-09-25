package dp

class BOJ11726 {
    fun solution() {
        val num = readln().toInt()
        val bp = mutableListOf<Int>(0, 1, 2, 3)

        for (i in 4..num) {
            bp.add(i, (bp[i - 1] + bp[i - 2]) % 10007)
        }
        println(bp[num])
    }
}