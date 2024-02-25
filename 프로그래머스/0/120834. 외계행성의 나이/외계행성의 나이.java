import java.util.*;
class Solution {
    public String solution(int age) {
        Stack<Integer> sta = new Stack<>();
        
        while(age != 0){
            sta.add(age%10);
            age /= 10;
        }
        String res = "";
        while(!sta.isEmpty()){
            res += Character.toString(sta.pop() + 'a');
        }
        
        return res;
    }
}