class Solution {
    public int solution(int a, int b, int n) {
        int res = 0;
        
        while( n >= a){
            int c = (n/a)*b;
            n = c + n%a;
            res += c;
        }
        
        
        return res;
    }
}