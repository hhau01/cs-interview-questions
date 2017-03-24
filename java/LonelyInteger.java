/*
    Find the lonely integer. Every number appears twice except for the 'lonely integer'.

    E.g. 9,1,2,3,2,9,1,7,7

    For this we will use bit manipulation:

    Convert integers to binary:
        9   1001
        1   0001
        2   0010
        3   0011
        2   0010
        9   1001
        1   0001
        7   0111
        7   0111

    Next, XOR all the integers. XOR-ing will only return a 1 when the inputs are 0 and 1. 
    E.g. 1001 ^ 0001 = 1000 or 1010 ^ 0101 = 1111

    So when we XOR all the integers above, we get: 0011, which is 3, our lonely integer.
*/

public class LonelyInteger {
    private static int lonelyInteger(int[] array) {
        int result = 0;
        for (int value: array) {
            result ^= value;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testArray = {9,1,2,3,2,9,1,7,7};

        // System.out.println(lonelyInteger(testArray));
        assert lonelyInteger(testArray) == 3;
    }
}