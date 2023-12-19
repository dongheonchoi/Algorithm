import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String ,Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i] , number[i]);
        }
        
        loop:
        for(int i = 0; i < discount.length-9; i++){
            HashMap<String ,Integer> tem = new HashMap<>();
            
            for(int j = 0 ; j < 10; j++){
                tem.put(discount[i+j] , tem.getOrDefault(discount[i+j] , 0)+1);    
            }
            
            for(String key : want){
                if( map.get(key) != tem.get(key)) continue loop;
            }
            
            answer++;
            
        }
        
        return answer;
    }
}