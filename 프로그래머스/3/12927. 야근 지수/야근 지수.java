import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
        
        long res = 0;
        
        for(int i = 0; i < works.length; i++){
            pQue.add(works[i]);    
        }
        
        for(int i = 0; i < n; i++){
            int a = pQue.poll();
            if(a == 0) {
                return 0;
            }else {
                a--;
                pQue.add(a);
            }
        }
        
        for(int i = 0; i < works.length; i++){
            int tem = pQue.poll();
            res += tem*tem;
        }
        
        
        return res;
    }
}