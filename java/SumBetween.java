/*
    Find the sum of all the numbers between a and b inclusive
    E.g.

    getSum(-1, 2): -1 + 0 + 1 + 2 = 2

    Solution: use summation formula
    (a + b) * (Math.abs(a-b) + 1) / 2 
*/
public class SumBetween {
    public int GetSum(int a, int b) {
        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }

    // No formula
    public int GetSum2(int a, int b) {
        int sum = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            sum += i;
        }
        return sum;
    }
}