import java.util.*;

public class Solution {
    public int[] solution(int []arr) {       
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for(int x : arr){
            if(x != stack.peek()){
                stack.push(x);
            }    
        }
        
        int[] answer = new int[stack.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = stack.get(i);
        }
        
        return answer;
    }
}