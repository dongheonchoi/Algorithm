class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] res = new int[num_list.length];
        
        int ii = num_list.length;
        
        for(int i = 0; i < n; i++){
            res[ii - n + i] = num_list[i];
        }
        
        ii = 0;
        for(int i = n; i < num_list.length; i++){
            res[ii++] = num_list[i];    
        }
        
        
        
        return res;
    }
}