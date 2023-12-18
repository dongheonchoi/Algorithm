class Solution {
    static boolean[] tf;
    static int k , res ,tem , len;
    static int[][] arr;
    
    
    public int solution(int p, int[][] dungeons) {
        k = p;
        arr = dungeons;
        len = dungeons.length;
        res = 0;
        tem = 0;
        
        tf = new boolean[len];
        
        dfs();
        
        return res;
    }
    
    public static void dfs(){
        if(tem > res) res = tem;
        
        for(int i = 0; i < len; i++){
            if( k >= arr[i][0] && !tf[i]){
                k-=arr[i][1];
                tf[i] = true;
                tem++;
                
                dfs();
                
                k+=arr[i][1];
                tf[i] = false;
                tem--;
            }
        }

    }
    
}