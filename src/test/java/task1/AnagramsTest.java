package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramsTest {

    @Test
    public void twoWordsContainsAnagramTest(){
        Anagrams anagrams = new Anagrams();
        String word1 = "abcdef";
        String word2 = "bcdaef";
        String expected = "Strings are anagrams";

        assertEquals(expected, anagrams.isAnagram(word1, word2));

    }

    @Test
    public void twoWordsDontContainsAnagrams(){
        Anagrams anagrams = new Anagrams();
        String word1 = "abcdef";
        String word2 = "aacdfg";
        String expected = "[b, e]";

        assertEquals(expected, anagrams.isAnagram(word1, word2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void differentWordsLengthTest(){
        Anagrams anagrams = new Anagrams();
        String word1 = "abcdeff";
        String word2 = "aacdfg";
        anagrams.isAnagram(word1, word2);
    }
}