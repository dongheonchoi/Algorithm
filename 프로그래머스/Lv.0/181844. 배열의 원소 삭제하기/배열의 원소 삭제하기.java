class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        boolean[] tf = new boolean[1001];
        int len = delete_list.length;
        for(int i = 0; i < len; i++){
            tf[delete_list[i]] =true;    
        }
        
        int[] answer = new int[arr.length];
        
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(!tf[arr[i]]){
                answer[cnt++] = arr[i];
            }
        }
        
        int[] res = new int[cnt];
        
        for(int i= 0; i < cnt; i++){
            res[i] = answer[i];
        }
        
        return res;
    }
}