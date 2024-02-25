import java.util.*;

class Solution {
    
    static int[][] map;
    static int res, K , N;
    static HashMap<Integer, Queue<int[]>> hashMap;
    public int solution(int k, int n, int[][] reqs) {
        
        res = Integer.MAX_VALUE;
        
        hashMap = new HashMap<>();
        K = k;
        N = n;
        
        for(int i = 1; i <= k; i++){
            hashMap.put(i, new LinkedList<>());
        }

        for(int i = 1; i <= k; i++){
            for(int j = 0; j < reqs.length; j++ ){
                if(reqs[j][2] == i){
                    //reqs배열을 건드리지 않을거라 clone을 굳이 하지 않음

                    hashMap.get(i).add(reqs[j]);
                }
            }
        }

        map = new int[n-k+2][k+1]; //상담사 수  /  유형

        for(int j = 1; j < k+1; j++){
            for(int i = 1; i < n-k+2; i++){
                if(fn(i , j) == 0) break;
            }
        }


        method(1 , 0 , 0);

        return res;
    }
    
    static int fn(int num , int type){ // 상담수 , 타입
        int temValue = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Queue<int[]> temQ = hashMap.get(type);
        
        for(int i = 0; i < temQ.size(); i++){
            int[] temA = temQ.poll();


            if(pq.size() == num){
                int a = pq.poll();
                if(a > temA[0]){
                    temValue = temValue + a -temA[0];

                    pq.add(a + temA[1]);
                }else{
                    pq.add(temA[0]+temA[1]);
                }
            }else{
                pq.add(temA[0] + temA[1]);

            }

            temQ.add(temA);
        }

        map[num][type] = temValue;

        return temValue;
    }
    
    static void method(int type , int num , int temRes){
        if(num > N){
            return;
        }
        if(type == K+1){
            if(num == N && res > temRes){
                res = temRes;
            }
            return;
        }

        for(int i = 1; i < N-K+2; i++){
            int a = map[i][type];
            method(type + 1 , num + i, temRes + a);
            // if(a == 0) break;
        }
    }
}