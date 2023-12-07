class Solution {
    static int res ,sum ,tar ,len;
    static int[] arr;    
    public int solution(int[] numbers, int target) {
        res = 0;
        sum = 0;
        tar = target;
        len = numbers.length;
        arr = numbers;
        fn(0);
        
        return res;
    }
    static void fn(int idx){
        if(idx == len ){
            if(sum == tar) res++;    
            return;            
        }
        
        sum += arr[idx];
        fn(idx+1);
        sum -= arr[idx];
        sum -= arr[idx];
        fn(idx+1);
        sum += arr[idx];
    }
}