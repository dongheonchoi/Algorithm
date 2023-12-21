class Solution {
    public int solution(int[] num_list) {
        int res = 0;
        
        String odd = "";
        String even = "";
        
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 1){
                odd += num_list[i];
            }else{
                even += num_list[i];
            }
        }
        
        if(odd.length() != 0){
            res += Integer.parseInt(odd);
        }
        
        if(even.length() != 0){
            res += Integer.parseInt(even);
        }
        
        return res;
    }
}