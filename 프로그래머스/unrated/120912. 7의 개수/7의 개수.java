class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int i = 0; i < array.length; i++){
            String tem = "";
            tem += array[i];
            for(int j = 0; j < tem.length(); j++){
                if(tem.charAt(j) == '7') answer++;
            }
        }
        
        
        return answer;
    }
}