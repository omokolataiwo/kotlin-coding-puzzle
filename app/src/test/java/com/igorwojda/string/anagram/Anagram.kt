package com.igorwojda.string.anagram

import org.amshove.kluent.shouldEqual
import org.junit.Test

private fun anagrams(str1: String, str2: String): Boolean {
    return false
}

class AnagramTest {
    @Test
    fun `"rail safety" is an anagram of "fairy tales"`() {
        anagrams("rail safety", "fairy tales") shouldEqual true
    }

    @Test
    fun `"RAIL! SAFETY!" is an anagram of "fairy tales" - ignore letter casing`() {
        anagrams("RAIL SAFETY", "fairy tales") shouldEqual true
    }

    @Test
    fun `"RAIL! SAFETY!" is an anagram of "fairy tales" - ignore special characters`() {
        anagrams("rail safety!!", "fairy tales") shouldEqual true
    }

    @Test
    fun `"hi" is an anagram of "ihi"`() {
        anagrams("hi", "ihi") shouldEqual false
    }

    @Test
    fun `"hello" is an anagram of "llohe"`() {
        anagrams("hello", "llohe") shouldEqual true
    }

    @Test
    fun `"Whoa! Hi!" is an anagram of "Hi! Whoa!"`() {
        anagrams("Whoa! Hi!", "Hi! Whoa!") shouldEqual true
    }

    @Test
    fun `"One One" is not an anagram of "Two two two"`() {
        anagrams("One One", "Two two two") shouldEqual false
    }

    @Test
    fun `"One one" is not an anagram of "One one c"`() {
        anagrams("One one", "One one c") shouldEqual false
    }

    @Test
    fun `"One one" is not an anagram of "One one  " - ignore spaces`() {
        anagrams("One one", "One one  ") shouldEqual true
    }

    @Test
    fun `"A tree, a life, a bench" is not an anagram of "A tree, a fence, a yard"`() {
        anagrams("A tree, a life, a bench", "A tree, a fence, a yard") shouldEqual false
    }
}
