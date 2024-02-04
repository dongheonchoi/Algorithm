import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] res = {0 , 0};
        
        HashMap<String , Integer> map = new HashMap<>();
        
        map.put(words[0] , 0 );
        
        char a = words[0].charAt(words[0].length()-1);
        for(int i = 1; i < words.length; i++){
            if(a == words[i].charAt(0) && !map.containsKey(words[i])){
                map.put(words[i] , 0 );
                a = words[i].charAt(words[i].length()-1);
            }else{
                res[0] = i%n + 1;
                res[1] = i/n + 1;
                return res;  
            }
        }
        return res;
    }
}