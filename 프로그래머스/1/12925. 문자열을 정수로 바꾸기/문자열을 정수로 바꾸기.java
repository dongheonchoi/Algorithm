import java.util.*;
class Solution {
    public int solution(String s) {
        int len = s.length();
        
        int res=0;
        int posi = 1;
        boolean min = false;
        for(int i = len-1; i >= 0; i--){
            char a = s.charAt(i);
            if(a == '-' || a == '+'){
                if(a == '-' ){
                    min = true;
                }
                break;
            }
            res += (a-48)*posi;
            posi*=10;
        }
        if(min){
            res*= -1;    
        }
        return res;
    }
}