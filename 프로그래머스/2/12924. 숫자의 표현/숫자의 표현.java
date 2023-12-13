class Solution {
    public int solution(int n) {
        int res = 0;
        int tem = 0;
        for(int i = 1; i <= n; i++){
            tem = 0;
            for(int j = i; j <= n; j++){
                tem+=j;
                if(tem == n) res++;
                else if(tem > n) break;
            }
            
        }
        
        
        return res;
    }
}