class Solution {
    public int[] solution(int n) {
        int[] arr = new int[10001];
        
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if( n%i == 0){
                arr[cnt++] = i;
            }
        }
        
        int[] answer = new int[cnt];
        
        for(int i = 0; i < cnt; i++ ){
            answer[i] = arr[i];
        }
        
        
        return answer;
    }
}