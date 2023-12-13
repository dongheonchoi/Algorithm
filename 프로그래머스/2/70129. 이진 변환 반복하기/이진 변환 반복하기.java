class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int time = 0;
        int len = s.length();
        while(true){
            time++;
            int temCnt = 0;
            for(int i = 0 ; i < len ; i++){
                if(s.charAt(i) == '0') {
                    temCnt++;
                }
            }
            cnt += temCnt;
            len -= temCnt;
            s = Integer.toBinaryString(len);
            len = s.length();
            
            if(len == 1) break;

        }

        int[] answer = {time , cnt};
        return answer;
    }
}