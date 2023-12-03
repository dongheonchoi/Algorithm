import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            if(sb.charAt(i) == ' '){
                idx = 0;
                continue;
            }
            if(idx%2 == 0 && sb.charAt(i) >= 97 && sb.charAt(i) < 123 ){
                sb.replace(i , i+1, Character.toString(sb.charAt(i)-' '));
            }
            if(idx%2 == 1 && sb.charAt(i) >= 65 && sb.charAt(i) < 91){
                sb.replace(i , i+1, Character.toString(sb.charAt(i)+' '));
            }
            idx++;
        }
      
        return sb.toString();
    }
}