import java.util.*;
class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s , " ");
        
        int max = Integer.parseInt(st.nextToken());
        int min = max;
        
        while(st.hasMoreElements()){
            int a = Integer.parseInt(st.nextToken());
            if( a > max) max = a;
            if( a < min) min = a;

        }
        
        
        return min + " " + max;
    }
}