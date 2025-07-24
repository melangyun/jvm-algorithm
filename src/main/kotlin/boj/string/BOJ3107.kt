package boj.string

/*
* input
* 1234::1
*
* output
* 1234:0000:0000:0000:0000:0000:0000:0001
*
* input
* 25:09:1985:aa:091:4846:374:bb

* output
* 0025:0009:1985:00aa:0091:4846:0374:00bb
* */
class BOJ3107 {
    fun solution() {
        val input = readln()
        val answer = mutableListOf<String>()
        val tags = input.split(":")
        var isSkipped = false

        for (tag in tags) {
            if(tag.isBlank() && isSkipped){
                answer.add("0000")
                continue
            }
            if (tag.isBlank()) {
                repeat(8 - tags.size + 1) {
                    answer.add("0000")
                }
                isSkipped = true
                continue
            }
            answer.add(tag.padStart(4, '0'))
        }
        println(answer.joinToString(":"))
    }
}