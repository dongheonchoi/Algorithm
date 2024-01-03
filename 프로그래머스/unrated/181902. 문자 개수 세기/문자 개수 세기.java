class Solution {
    public int[] solution(String my_string) { // 65 ~ 90  97~122 
        int[] answer = new int[52];
        
        for(int i = 0; i < my_string.length() ; i++){
            int a = my_string.charAt(i);
            if(a >= 65 && a <=90){
                answer[a-65]++;
            }else{
                answer[a-71]++;
            }
        }
        
        return answer;
    }
}