import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < sizes.length; i++){
            a = Math.max(Math.max(sizes[i][0],sizes[i][1]) , a);
            b = Math.max(Math.min(sizes[i][0],sizes[i][1]) , b);
        }
        
        return a*b;
    }
}