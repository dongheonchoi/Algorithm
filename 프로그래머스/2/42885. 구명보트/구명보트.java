import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int len = people.length;
        for(int i = 0; i < len; i++){
            answer ++;
            for(int j = len-1; j > i ; j-- ){
                if(people[i] + people[j] <= limit){
                    len = j;
                    break;
                }else{
                    answer++;
                    len = j;
                }

            }
            
        }
        return answer;
    }
}