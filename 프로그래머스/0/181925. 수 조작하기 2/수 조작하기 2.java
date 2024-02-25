class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        int tem = numLog[0];
        
        for(int i = 1; i < numLog.length; i++){
            if(tem - numLog[i] == -1){
                answer+="w";
            }else if(tem - numLog[i] == 1){
                answer+="s";
            }else if(tem - numLog[i] == -10){
                answer+="d";
            }else{
                answer+="a";
            }
            tem = numLog[i];
        }
        
        return answer;
    }
}