class Solution {
    public int solution(int balls, int share) {
        long answer = 1;
        int idx = 1;
        for(int i = share+1; i <= balls; i++){
            answer *= i;
            answer /= idx;
            idx++;
        }
        
        return (int)answer;
    }
}