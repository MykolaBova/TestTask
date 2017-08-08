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
     * @param firstWord first word
     * @param secondWord second word
     * @return String message "Strings are anagrams" if words are anagrams
     * or letters you need to change in first word to
     */
    public String isAnagram(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null || firstWord.isEmpty() || secondWord.isEmpty()) {
            throw new IllegalArgumentException("Words can't be null or empty");
        }
        if (firstWord.length() != secondWord.length()) {
            throw new IllegalArgumentException("Words have different length");
        }

        wordValidator(firstWord);
        wordValidator(secondWord);

        char [] firstWordArr = firstWord.toLowerCase().toCharArray();
        char [] secondWordArr = secondWord.toLowerCase().toCharArray();

        //Method sort from Arrays class worst-case complexity O(n log n).
        Arrays.sort(firstWordArr);
        Arrays.sort(secondWordArr);

        if (Arrays.equals(firstWordArr, secondWordArr)) {
            return "Strings are anagrams";
        } else {
            return findUniqueCharacters(firstWordArr, secondWordArr);
        }
    }

    /**
     * Method find all the letters you need to change in the first
     * string to make the two strings anagrams.
     * Arrays should be sorted
     * Complexity of this method is O(n)
     * @param firstWordArr first char array
     * @param secondWordArr second char array
     * @return String of characters
     */
    private String findUniqueCharacters(char[] firstWordArr, char[] secondWordArr){
        HashSet<Character> firstWordSet = new HashSet<>();
        HashSet<Character> secondWordSet = new HashSet<>();

        for(int i = 0; i < firstWordArr.length; i++){
            firstWordSet.add(firstWordArr[i]);
            secondWordSet.add(secondWordArr[i]);
        }
        firstWordSet.removeAll(secondWordSet);

        return firstWordSet.toString();
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

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
//        String firstWord = "abcd";
//        String secondWord = "dbac";
        String firstWord = args[0];
        String secondWord = args[1];
        System.out.println(anagrams.isAnagram(firstWord, secondWord));
    }
}