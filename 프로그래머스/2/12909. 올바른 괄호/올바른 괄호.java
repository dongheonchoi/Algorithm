import java.util.*;
class Solution {
    boolean solution(String s) {
        
        Stack<Integer> sta = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                sta.push(0);    
            } 
            else{
                if(sta.isEmpty()){
                    return false;
                }else{
                    sta.pop();
                }     
            }
        }
        
        if(!sta.isEmpty()) return false;
        else return true;
        
        
        
        

        
    }
}