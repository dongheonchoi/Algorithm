import java.util.*;

class posi{
    int r;
    int c;
    int cnt;
    posi(int r, int c , int cnt){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Solution {
    static boolean[][] tf;
    static int N, M;
    static int[] dR = {0,-1,0,1};
    static int[] dC = {-1,0,1,0};   
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        
        tf = new boolean[N][M];

        Queue<posi> que = new LinkedList<>();
        
        que.add(new posi(0 , 0, 1));
        
        while(!que.isEmpty()){
            posi np = que.poll();
            
            for(int i = 0; i < 4; i++){
                int nR = np.r + dR[i];
                int nC = np.c + dC[i];
                
                if(nR >= 0 && nR < N && nC >= 0 && nC < M && !tf[nR][nC] && maps[nR][nC] != 0){
                    if(nR == N-1 && nC == M-1){
                        return np.cnt+1;
                    }else{
                        tf[nR][nC] = true;
                        que.add(new posi(nR, nC, np.cnt+1));
                    }
                }
            }
        }
        
        
        
        
        
        
        return -1;
    }
}