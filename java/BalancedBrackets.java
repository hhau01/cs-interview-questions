/*
    Check the string of brackets: (), {}, [] and return true if it is balanced

    Simply just push the opening bracket into a stack and check for the closing bracket. If it matches, return true. Else, return false.
*/

import java.util.Stack;

public class BalancedBrackets {
    public static char[][] TOKENS = {{'{','}'}, {'[',']'}, {'(',')'}};

    public static boolean isOpenTerm(char c) {
        for (char[] array : TOKENS) {
            if (array[0] == c) {
                return true;
            } 
        }
        return false;
    }

    public static boolean matches(char openTerm, char closeTerm) {
        for (char[] array : TOKENS) {
            if (array[0] == openTerm) {
                return array[1] == closeTerm;
            }
        }
        return false;
    }
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            if (isOpenTerm(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || (!matches(stack.pop(), c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        assert isBalanced("{({)})}") == false;
        assert isBalanced("{({})}") == true;
        // System.out.println(isBalanced("{({)})}"));
    }
}