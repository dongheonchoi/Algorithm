class Solution {
    public int solution(int n) {
        int res = 1;
        
        flag:
        for(int i = 3; i <= n; i++){
            
            for(int j = 2; j*j <= i; j++){
                if(i%j == 0) continue flag;
            }
            res++;
        }
        
        return res;
    }
}