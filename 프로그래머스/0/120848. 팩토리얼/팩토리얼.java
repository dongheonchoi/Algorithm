class Solution {
    public int solution(int n) {
        int answer = 0;
        int res = 1;

        for(int i=1; i<=10; i++){
            res *= i;
            
            if(res == n){
                answer = i;
                break;
            }else if(n < res){
                answer = (i-1);
                break;
            }
        }
        return answer;
    }
}