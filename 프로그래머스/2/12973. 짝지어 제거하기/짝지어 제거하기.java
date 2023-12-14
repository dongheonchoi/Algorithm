import java.util.*;
class Solution{
    public int solution(String s){
        Stack<Character> sta = new Stack<>();
        
        char tem = s.charAt(0);
        sta.push(tem);
        for(int i = 1; i < s.length(); i++){
            if(tem == s.charAt(i)){
                sta.pop();
                if(!sta.isEmpty()) tem = sta.peek();
                else tem = '0';
            }else{
                tem = s.charAt(i);
                sta.push(tem);
            }
        }
        
        if(!sta.isEmpty()) return 0;
        else return 1;
        
    }
}