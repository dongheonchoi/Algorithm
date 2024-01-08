class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for(int i = 0; i < num_list.length; i++){
            int a = num_list[i];
            
            while(a != 1){
                answer++;
                if(a % 2 == 0) a/=2;
                else a = (a-1)/2;
                
            }
            
            
        }
        
        
        return answer;
    }
}