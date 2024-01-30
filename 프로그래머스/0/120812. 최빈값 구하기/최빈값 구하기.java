class Solution {
    public int solution(int[] array) {
        // int num = -1;
        int tem = -1;
        int res = 0;
        
        int[] arr = new int[1000];
        
        for( int i = 0; i < array.length ; i++){
            arr[array[i]]++;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(tem < arr[i]){
                tem = arr[i];
                res = i;
            }else if(tem == arr[i]){
                res = -1;
            }
        }
        
        
        return res;
    }
}