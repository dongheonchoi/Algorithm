class Solution {
    public int solution(int[] num_list) {
        int tem1 = 0;
        int tem2 = 1;
        for(int i = 0; i < num_list.length; i++){
            tem1 += num_list[i];
            tem2 *= num_list[i];
        }
        
        if(tem2 < tem1*tem1) return 1;
        else return 0;
        
    }
}