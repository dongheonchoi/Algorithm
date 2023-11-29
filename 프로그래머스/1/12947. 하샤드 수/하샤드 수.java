class Solution {
    public boolean solution(int x) {
        
        int y = x;
        int sum = 0;
        
        for(int i = 0; i < 5; i++){
            sum += x%10;
            x/=10;
        }
        
        boolean res = false;
        
        if(y%sum == 0 ) res=true;
        return res;
    }
}