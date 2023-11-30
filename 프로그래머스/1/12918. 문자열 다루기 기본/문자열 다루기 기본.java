import java.util.*;
class Solution {
    public boolean solution(String s) {
        boolean result = false;
        
        if(s.length() == 4 || s.length() == 6){
            
		result = s.matches("(^[0-9]*$)");
        
        }
    
        return result;
    }
}