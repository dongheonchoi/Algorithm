class Solution {
    public int[] solution(int[] arr) {
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            cnt += arr[i];
        }
        
        int[] res = new int[cnt];
        
        int num = 0;
        for(int i = 0; i < arr.length; i++){
            int tem =arr[i];
            for(int j = 0; j < tem; j++){
                res[num++] = tem;
            }
        }
        
        return res;
    }
}