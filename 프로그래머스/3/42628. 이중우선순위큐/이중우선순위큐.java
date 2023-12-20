import java.util.*;
class Solution {
    public int[] solution(String[] operations) {

        int[] res = new int[2];
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());        
        
        int cnt = 0;
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            if(st.nextToken().equals("I")){
                cnt++;
                int a = Integer.parseInt(st.nextToken());
                pq1.add(a);
                pq2.add(a);
            }else{
                if(cnt != 0){
                    cnt--;
                    if(cnt == 0){
                        pq1.clear();
                        pq2.clear();
                    }
                    int b = Integer.parseInt(st.nextToken());
                    if(b == -1){
                        pq1.poll();
                    }else{
                        pq2.poll();
                    }
                }
            }

        }
        res[0] = 0;
        res[1] = 0;
        if(cnt != 0){
            res[0] = pq2.poll();
            res[1] = pq1.poll();
        }        
        
        
        
        return res;
    }
}