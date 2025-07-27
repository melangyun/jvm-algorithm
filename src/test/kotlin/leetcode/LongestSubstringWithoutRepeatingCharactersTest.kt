package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LongestSubstringWithoutRepeatingCharactersTest{
    @Test
    fun longestSubstringWithoutRepeatingCharactersTest1(){
        val solution = LongestSubstringWithoutRepeatingCharacters()
        val result = solution.lengthOfLongestSubstring("abcabcbb")
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun longestSubstringWithoutRepeatingCharactersTest2(){
        val solution = LongestSubstringWithoutRepeatingCharacters()
        val result = solution.lengthOfLongestSubstring("bbbbb")
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun longestSubstringWithoutRepeatingCharactersTest3(){
        val solution = LongestSubstringWithoutRepeatingCharacters()
        val result = solution.lengthOfLongestSubstring("pwwkew")
        assertThat(result).isEqualTo(3)
    }

}