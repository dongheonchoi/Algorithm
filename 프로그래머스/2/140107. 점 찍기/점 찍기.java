class Solution {
    public long solution(int k, long d) {
        long answer = 0;
        
        for(long i = 0 ; i <= d; i+=k){
            long a = (long) Math.sqrt(d*d - i*i); 
            answer += (a/k) + 1;
        }
        
        
        return answer;
    }
}