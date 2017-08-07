package task1;

import java.util.Arrays;
import java.util.HashSet;

public class Anagrams {

    /**
     * Method define if two words are anagrams.
     *
     * Method checks for nulls, lengths and empty Strings, if they exists
     * @throws IllegalArgumentException
     *
     * @param word1 first word
     * @param word2 second word
     * @return String message "Strings are anagrams" if words are anagrams
     * or letters you need to change in first word to
     */
    public String isAnagram(String word1, String word2) {
        if (word1 == null || word2 == null) throw new IllegalArgumentException("Words can't be null");
        if (word1 == "" || word2 == "") throw new IllegalArgumentException("One or two words is empty");
        if (word1.length() != word2.length()) throw new IllegalArgumentException("Words have different length");

        wordValidator(word1);
        wordValidator(word2);

        char [] word1array = word1.toLowerCase().toCharArray();
        char [] word2array = word2.toLowerCase().toCharArray();

        Arrays.sort(word1array);
        Arrays.sort(word2array);

        if (Arrays.equals(word1array, word2array)) {
            return "Strings are anagrams";
        } else {
            return findUniqueCharacters(word1array, word2array);
        }
    }

    /**
     * Method find all the letters you need to change in the first
     * string to make the two strings anagrams.
     * Complexity of this method is O(1)
     * @param word1array first char array
     * @param word2array second char array
     * @return String of characters
     */
    private String findUniqueCharacters(char[] word1array, char[] word2array){
        HashSet<Character> word1Set = new HashSet<>();
        HashSet<Character> word2Set = new HashSet<>();

        for(int i = 0; i < word1array.length; i++){
            word1Set.add(word1array[i]);
            word2Set.add(word2array[i]);
        }
        word1Set.removeAll(word2Set);

        return word1Set.toString();
    }

    /**
     * Method validates word. Word can contain only letters.
     * Complexity of this method is O(n)
     * @throws IllegalArgumentException if word contain other symbols
     * @param word for validation
     */
    private void wordValidator (String word){
        if (!word.matches("[a-zA-Z]+")) throw new IllegalArgumentException("Words can contain only letters");
    }
}