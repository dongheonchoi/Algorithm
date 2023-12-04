import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for(int i = 0 ; i < s.length() ; i++ ){
            char a = sb.charAt(i);
            if( a >= 65 && a < 91){
                a += n;
                if( a >= 91 ) a -= 26;
                sb.replace(i,i+1 , Character.toString(a));
            }else if( a >= 97 && a < 123){
                a += n;
                if( a >= 123 ) a -= 26;
                sb.replace(i,i+1 , Character.toString(a));
            }
        }

        return sb.toString();
    }
}