import java.util.*;
class Solution {
    static Integer[] nA;
    static int res ,target ,a;
    static boolean[] tf;
    
    
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        
        int[] arr = new int[100001];
        
        target = k;
        
        res = Integer.MAX_VALUE;
        
        a = 0;
        int tem = tangerine[0];
        
        for(int i = 0 ; i <tangerine.length ; i++ ){
            if(tem == tangerine[i]) {
                arr[a]++;  
            } else {
                a++;
                tem = tangerine[i];
                arr[a]++;
            }
        }
        
        
        
        nA = new Integer[a+1];
        
        for(int i = 0; i <= a ; i++){
            nA[i] = arr[i];
        }
        
        Arrays.sort(nA , Collections.reverseOrder());
        
        
        dfs(0 , 0 , 0);
        
        return res;
    }
    
    public static void dfs(int idx ,int cnt ,int sum){
        // System.out.println("idx : " + idx + " cnt : " + cnt + " sum : " +sum);
    
        if(cnt >= res) return;
        
        if(sum >= target) {
            res = cnt;
            return;
        }
        if(idx > a ) return;
        // System.out.println("nA[idx] : " + nA[idx] );
        
        // dfs(idx+1 , cnt , sum);
        
        dfs(idx+1 , cnt+1 , sum + nA[idx]);
        
        
        
        
        
        
        
    }
    
    
    
}