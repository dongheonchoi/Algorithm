import java.util.*;

class Solution {
    public int solution(int k, int m, int[] a) {
        Integer[] score = Arrays.stream(a).boxed().toArray(Integer[]::new);
        
        Arrays.sort(score , Collections.reverseOrder());
        
        int res = 0;
        
        for(int i = m-1 ; i < score.length; i+=m){
            res += score[i]*m;
        }

        return res;
    }
}