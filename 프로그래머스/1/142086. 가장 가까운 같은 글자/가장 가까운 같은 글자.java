import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] res = new int[s.length()];
        
        int[] posi = new int[123];
        
        Arrays.fill(posi , -1);
        
        for(int i = 0; i < s.length(); i++){
            if(posi[s.charAt(i)] == -1) {
                res[i] = -1;
                posi[s.charAt(i)] = i;
            }else{
                res[i] = i - posi[s.charAt(i)];
                posi[s.charAt(i)] = i;
            }
        }

        //48 65 97 26 123
        
        return res;
    }
}