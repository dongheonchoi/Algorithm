class Solution {
    public int solution(long num) {
        int answer = -1;
        if(num==1){
            return 0;
        }
        
        int cnt = 0;
        while(cnt != 500){
            cnt++;
            if(num%2==0){
                num/=2;
            }else{
                num = 3*num+1;
            }
            if(num == 1){
                answer = cnt;
                break;
            }
        }
        
        return answer;
    }
}