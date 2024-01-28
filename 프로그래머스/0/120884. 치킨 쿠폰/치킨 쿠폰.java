class Solution {

    public int solution(int chicken) {
        int answer = 0;
        
        while (chicken >= 10) {
            int a = chicken / 10;
            int b = chicken % 10;
            chicken = a + b;

            answer += a;
        }

        return answer;
    }
}