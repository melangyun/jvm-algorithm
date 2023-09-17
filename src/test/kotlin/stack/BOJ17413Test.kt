package stack

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BOJ17413Test {
    private val testCase = listOf(
        "baekjoon online judge" to "noojkeab enilno egduj",
        "<open>tag<close>" to "<open>gat<close>",
        "<ab cd>ef gh<ij kl>" to "<ab cd>fe hg<ij kl>",
        "one1 two2 three3 4fourr 5five 6six" to "1eno 2owt 3eerht rruof4 evif5 xis6",
        "<int><max>2147483647<long long><max>9223372036854775807" to "<int><max>7463847412<long long><max>7085774586302733229",
        "<problem>17413<is hardest>problem ever<end>" to "<problem>31471<is hardest>melborp reve<end>",
        "<   space   >space space space<    spa   c e>" to "<   space   >ecaps ecaps ecaps<    spa   c e>",
    )

    @Test
    fun 문제1번() {
        testCase.forEach {
            BOJ17413().solution(it.first) shouldBe it.second
        }
    }
}