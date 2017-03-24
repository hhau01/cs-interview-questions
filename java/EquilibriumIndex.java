/*
    Find the equilibrium index where the left side equals the right side
    E.g. a = [-1, 3, -4, 5, 1, -6, 2, 1]
         P = 1 is an equilibrium index because:
         a[0] = -1 = a[2] + a[3] + a[4] + a[5] + a[6] + a[7]

         P = 3 is an equilibrium index because:
         a[0] + a[1] + a[2] = -2 = a[4] + a[5] + a[6] + a[7]

         P = 7 is an equilibrium index because:
         a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] = 0

    This solution does not work for extremely large positive or negative numbers nor does it work for arithmetic overflow numbers.
*/

public class EquilibriumIndex {
    public int solution(int[] A) {
        int rightWindow = 0;
        int leftWindow = 0;
        
        for (int i = 0; i < A.length; i++) {
            rightWindow += A[i];    
        }
        
        for (int i = 0; i < A.length; i++) {
            rightWindow -= A[i];
            
            if (leftWindow == rightWindow) {
                return i;
            }
            leftWindow += A[i];
        }
        return -1;
    }
}