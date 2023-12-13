import java.util.*;
class Solution {
    public int solution(int n) {
        String str = Integer.toBinaryString(n);
        int cnt = 0;
        
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == '1') cnt++;
        }
            
        
        for(int i = n+1; i < 1000001; i++){
            str = Integer.toBinaryString(i);
            int tem = 0;
            for(int j = 0; j < str.length();j++){
                if(str.charAt(j) == '1') tem++;
            }
            if(cnt == tem) return i;
        }
        
        return 0;
    }
}