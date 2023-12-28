import java.util.*;
class Solution {

    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] tf = new boolean[n][m];
        int[][] map = new int[n][m];
        

            
        for(int i = 0; i < puddles.length; i++){
            tf[puddles[i][1]-1][puddles[i][0]-1] = true;
            
        }
        
        for(int i = 0; i < m; i++){
            if(!tf[0][i]){
                map[0][i] = 1;
            }else{
                break;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!tf[i][0]){
                map[i][0] = 1;
            }else{
                break;
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j <m; j++){
                if(!tf[i][j]){
                    map[i][j] = (map[i-1][j]+map[i][j-1])%1000000007;
//                    System.out.println(map[i][j]);
                }
            }
        }
        
        // for(int i = 0; i < map.length; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        
        
        return map[n-1][m-1];
    }
}