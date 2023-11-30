class Solution {
    public String solution(int n) {
        String answer = "";
        String su = "수박";
        if( n%2 == 0){
            answer = su.repeat(n/2);
        }else{
            answer = su.repeat((int)n/2) + "수";
        }
        return answer;
    }
}