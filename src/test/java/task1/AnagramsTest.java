package task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramsTest {

    @Test
    public void twoWordsContainsAnagramTest(){
        Anagrams anagrams = new Anagrams();
        String expected = "Strings are anagrams";

        assertEquals(expected, anagrams.isAnagram("abcdef", "bcdaef"));
        assertEquals(expected, anagrams.isAnagram("acer", "reca"));
    }

    @Test
    public void twoWordsContainsAnagramAndUpperCaseWordsTest(){
        Anagrams anagrams = new Anagrams();
        String expected = "Strings are anagrams";

        assertEquals(expected, anagrams.isAnagram("Asus", "sUsA"));
        assertEquals(expected, anagrams.isAnagram("Acer", "acer"));
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

    @Test(expected = IllegalArgumentException.class)
    public void oneEmptyWordsTest(){
        Anagrams anagrams = new Anagrams();
        String word1 = "";
        String word2 = "aacdfg";
        anagrams.isAnagram(word1, word2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneWordsNullTest(){
        Anagrams anagrams = new Anagrams();
        String word1 = null;
        String word2 = "word";
        anagrams.isAnagram(word1, word2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneWordsContainNumberTest(){
        Anagrams anagrams = new Anagrams();
        String word1 = "wor5";
        String word2 = "word";
        anagrams.isAnagram(word1, word2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneWordsContainSymbolTest(){
        Anagrams anagrams = new Anagrams();
        String word1 = "word";
        String word2 = "wo-d";
        anagrams.isAnagram(word1, word2);
    }
}