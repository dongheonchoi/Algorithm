import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long a = (long)Math.pow(n , 0.5);
        
        if(a*a == n) return (long)Math.pow(a+1 ,2);
        else return -1;
        
    }
}