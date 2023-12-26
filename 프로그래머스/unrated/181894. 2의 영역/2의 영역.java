class Solution {
    public int[] solution(int[] arr) {
        int a = 0;
        int b = arr.length;
        
        boolean flag = false;
        for(int i = 0 ; i < b; i++){
            if(arr[i] == 2){
                a = i;
                flag = true;
                break;
            }
        }
        
        if(!flag){
            int[] tem = {-1};
            return tem;
        }
        
        for(int i = b - 1; i >= 0; i--){
            if(arr[i] == 2){
                b = i;
                break;
            }
        }
        

        int[] res = new int[b-a+1];

        for(int i = 0 ; i < res.length; i++){
            res[i] = arr[i+a];
        }
        return res;
        
        
        
        
        
    }
}