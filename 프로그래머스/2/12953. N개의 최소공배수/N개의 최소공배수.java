class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        loop:
        while( true ){
            answer++;
            
            for(int i = 0; i < arr.length ; i++){
                if( answer % arr[i] != 0) continue loop;
            }
            
            break;
        }
        
        
        return answer;
    }
}