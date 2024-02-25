import java.util.*;
class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int s = i; s <= j; s++){
            int tem = s;
            while( tem != 0){
                if(tem%10 == k){
                    answer++;
                }                             
                tem/=10;
            } 
            
        }
        
        return answer;
    }
}