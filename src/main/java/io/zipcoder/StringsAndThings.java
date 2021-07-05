package io.zipcoder;

import org.apache.commons.lang3.*;


import com.sun.tools.javac.code.Attribute;

import java.lang.reflect.Array;
import java.util.Locale;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        int count = 0;
                /* String noSym = input.replaceAll("[^a-zA-Z]", ""); */
        String[] wordArray = input.toLowerCase().split(" ");
        //turns string into array splitting from the " " empty spaces
        for (int i = 0; i < wordArray.length; i++) {
            String currentWord = wordArray[i];
            boolean endsWithY = currentWord.endsWith("y");
            boolean endsWithZ = currentWord.endsWith("z");
            boolean endsWithYOrZ = endsWithZ || endsWithY;
            if (endsWithYOrZ) {
                count++;
            }
        }
        return count;
    }
       /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String baseRemoved = StringUtils.removeIgnoreCase(base, remove);
        return baseRemoved;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        String isIt = "is";
        String notIt = "not";
        int isCount = StringUtils.countMatches(input, isIt);
        int notCount = StringUtils.countMatches(input, notIt);
        if (isCount == notCount) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    /* search string for g, once g is found ask if next char is g, if no, return false, if yes continue till the end of
    the string or next g which would cause the evaluation again.
     */

    public Boolean gIsHappy(String input) {
        boolean result = true;
        for (int index = 0; index < input.length(); index++) {
            // moving through the string
            if (input.charAt(index) == 'g') {
                //if the string at a certain index = g return true
                if (input.charAt(index + 1) != 'g' && input.charAt(index -1) != 'g') {
                    //if the char to the right is not g and the char to the left is not g
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
       int count = 0;
       for (int index = 0; index < input.length()-2; index++){
        // moving through the string, -2 is preventing the loop from going out of range
           char currentChar = input.charAt(index);
               //the char at the current index with in the loop
            if (currentChar == input.charAt(index + 1) && currentChar == input.charAt(index + 2)){
                // the char at the current index is the same as the next one AND the one after it
                count += 1;
               }
       } return count;

    }
}
// .chartAt(the integer of the index of the string you're looking at)