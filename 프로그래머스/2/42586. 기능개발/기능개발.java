import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        for(int i = 0; i < progresses.length; i++){
            progresses[i] = ((100-progresses[i]-1)/speeds[i])+1;
        }
     
        int[] tem = new int[speeds.length];
        
        int a = progresses[0];
        tem[0] = 1;
        int idx = 0;
        
        for(int i = 1; i < progresses.length; i++){
            if(progresses[i] <= a){
                tem[idx]++;
            }else{
                a = progresses[i];
                tem[++idx] = 1;
            }
        }  
        int[] res = new int[idx+1];
        for(int i = 0; i <= idx; i++){
            res[i] = tem[i];
        }
        return res;
    }
}