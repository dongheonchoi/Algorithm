class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int begin = (total/num) - ((num - 1)/2);
        
        for(int i = 0; i < num; i++) {
            answer[i] = begin;
            begin++;
        }
        
        return answer;
    }
}