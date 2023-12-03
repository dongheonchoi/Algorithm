import java.util.*;
class Solution {
    public int solution(int n) {
        int[] arr = new int[50];
        int idx = 0;
        while(n != 0){
            arr[idx] = n%3;
            n /= 3;
            idx++;
        }
        
        idx--;
        
        int idx2 = 0;
        int answer = 0;
        for(int i = idx ; i >= 0; i--){
            answer +=  arr[i]*Math.pow(3, idx2++);    
            
        }
        
        
        
        return answer;
    }
}