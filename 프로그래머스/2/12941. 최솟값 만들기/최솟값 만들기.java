import java.util.*;

class Solution{
    public int solution(int[] A, int[] B){
        int res = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        
        for(int i = 0; i < len; i++){
            res += A[i]*B[len-i-1];
        }
        
        
        return res;
    }

}