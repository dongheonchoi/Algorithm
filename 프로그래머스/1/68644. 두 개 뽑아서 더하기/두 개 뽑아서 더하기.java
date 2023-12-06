class Solution {
    public int[] solution(int[] numbers) {
        boolean[] arr = new boolean[201];
        
        int cnt = 0;
        for(int i = 0; i < numbers.length-1 ; i++){
            for(int j = i+1 ; j < numbers.length; j++){
                int a = numbers[i] + numbers[j];
                if(!arr[a]){
                    arr[a] = true;
                    cnt++;
                }
            }
        }
        int[] res = new int[cnt];
        int idx = 0;
        for(int i = 0; i <= 200; i++){
            if(arr[i]){
                res[idx++] = i;
            }
        }
        
        return res;
    }
}