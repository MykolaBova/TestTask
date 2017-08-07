package task1;

import java.util.Arrays;
import java.util.HashSet;

public class Anagrams {
    public String isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) throw new IllegalArgumentException("Words have different length");

        //TODO Check if word consist only from letters

        char [] word1array = word1.toLowerCase().toCharArray();
        char [] word2array = word2.toLowerCase().toCharArray();

        Arrays.sort(word1array);
        Arrays.sort(word2array);

        if (Arrays.equals(word1array, word2array)) {
            return "Strings are anagrams";
        } else {
            return find(word1array, word2array);
        }
    }

    public String find (char [] word1array, char [] word2array){
        HashSet<Character> unique = new HashSet<>();
        HashSet<Character> common = new HashSet<>();

        for(int i = 0; i < word1array.length; i++){
            unique.add(word1array[i]);
            common.add(word2array[i]);
        }
        unique.removeAll(common);

        return unique.toString();
    }
}