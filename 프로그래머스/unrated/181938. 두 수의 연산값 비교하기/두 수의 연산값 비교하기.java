class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String ab = "";
        
        ab+=a;
        ab+=b;
        int c = Integer.parseInt(ab);
        int d =2*a*b;
        
        if( c < d ){
            return d;
        }else{
            return c;
        }
        
    }
}