import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> sta = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            while(!sta.isEmpty() && prices[i] < prices[sta.peek()]){ // 떨어지지 않은 가격이 나올때까지 반복 또는 stack이 전부 빌때 까지
                answer[sta.peek()] = i - sta.peek();
                sta.pop();
            }    
            sta.push(i);
        }
        
        while(!sta.isEmpty()){
            answer[sta.peek()] = prices.length - sta.peek() -1;
            sta.pop();
        }
 
        return answer;
    }
}