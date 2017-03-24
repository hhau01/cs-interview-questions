/*
    Jaden Case is when you capitalize every first letter of a string.
    E.g.

    toJadenCase("hello my name is henry") = "Hello My Name Is Henry"

    returns null if phrase is null or empty
*/

import java.lang.Character;
public class JadenCase {
    public String toJadenCase(String phrase) {
        if(phrase == null || phrase.equals("")) return null;
            
        char[] array = phrase.toCharArray();
            
        for(int x = 0; x < array.length; x++) {
            if(x == 0 || array[x-1] == ' ') {
                array[x] = Character.toUpperCase(array[x]);
            }
        }
        return new String(array);
    }
}