class Solution {
    static int res , num;
    static int[][] map;
    static boolean[] tf;
    
    public int solution(int n, int[][] computers) {
        map = computers;
        num = n;
        tf = new boolean[n];        
        
        for(int i = 0 ; i < n ; i++){
            if(!tf[i]){
                res++;
                tf[i] = true;
                dfs(i);
            }
        }

        return res;
    }
    
    static void dfs(int r){
        
        for(int i = 0; i < num ; i++){
            if( map[r][i] == 1 && !tf[i]){
                tf[i] = true;
                dfs(i);
            }
        }
        
        
        
    }



}