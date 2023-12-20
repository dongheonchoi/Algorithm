import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] res = new int[n];
        
        if(n > s){
            int[] a = {-1};
            return a;
        }
        
        int aa = s%n;
        int bb = s/n;
        Arrays.fill(res , bb);
        
        for(int i = 0; i < aa; i++){
            res[n-1-i]++;
        }
        

        return res;
    }
}