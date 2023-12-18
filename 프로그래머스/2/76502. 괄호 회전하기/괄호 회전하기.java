import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        
        if(len % 2 == 1) return 0;
        
        int res = 0;
        
        loop:
        for(int i = 0; i < len; i++){
            Stack<Character> a = new Stack<>();
            
            for(int j = i; j < len; j++){
                char cha = s.charAt(j);
                if(cha == '[' || cha == '{' ||cha == '('){
                    a.push(cha);
                }else{
                    if(cha == ']'){
                        if(a.isEmpty() || a.pop() != '['){
                            continue loop;
                        }
                    }else if(cha == '}'){
                        if(a.isEmpty() || a.pop() != '{'){
                            continue loop;
                        }
                    }else if(cha == ')'){
                        if(a.isEmpty() || a.pop() != '('){
                            continue loop;
                        }
                    }
                    
                }

            }
            for(int k = 0; k < i; k++){
                char cha = s.charAt(k);
                if(cha == '[' || cha == '{' ||cha == '('){
                    a.push(cha);
                }else{
                    if(cha == ']'){
                        if(a.isEmpty() || a.pop() != '['){
                            continue loop;
                        }
                    }else if(cha == '}'){
                        if(a.isEmpty() || a.pop() != '{'){
                            continue loop;
                        }
                    }else if(cha == ')'){
                        if(a.isEmpty() || a.pop() != '('){
                            continue loop;
                        }
                    }
                    
                }
            }      
            res++; 
        }
        
        
        
        
        
        
        return res;
    }
}