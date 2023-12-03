import java.util.*;
class Solution {
    public long[] solution(int n, int m) {
        int a = Math.max(n,m);
        int[] arrN = new int[a+1];
        int[] arrM = new int[a+1];
        
        while (n != 1){
            for(int i = 2; i <= n; i++){
                if(n%i == 0){
                    arrN[i]++;
                    n /= i;
                    break;
                }
            }
        }
        while (m != 1){
            for(int i = 2; i <= m; i++){
                if(m%i == 0){
                    arrM[i]++;
                    m /= i;
                    break;
                }
            }
        }
        long res1 = 1;
        long res2 = 1;
        for(int i = 0; i <= a; i++){
            if(arrN[i] != 0 && arrM[i] != 0){
                res1 *= Math.pow(i , Math.min(arrN[i],arrM[i]));
            }
            if(arrN[i] != 0 || arrM[i] != 0){
                res2 *= Math.pow(i , Math.max(arrN[i],arrM[i]));
            }
        }
        
        long[] res = new long[2];
        res[0] = res1;
        res[1] = res2;
        
        return res;
    }
}