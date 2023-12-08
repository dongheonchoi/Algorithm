class Solution {
    static int res;
    static int[] arr;
    static boolean[] tfMap, tf;
    static int sum;
    public int solution(int[] nums) {
        res = 0;
        sum = 0;
        arr = nums;
        tfMap = new boolean[nums.length];
       
        fn(0 , 0);

        return res;
    }
    
    static void fn(int cnt , int idx){
        if( cnt == 3){
            tf = new boolean[1001];
            check();
            return;
        }
        for(int i = idx; i < arr.length ; i++){
            if(!tfMap[i]){
                sum += arr[i];
                tfMap[i] = true;
                fn(cnt+1 ,i+1);
                sum -= arr[i];
                tfMap[i] = false;
            }
        }
    }
    
    static void check(){
        for(int i = 2; i*i <= sum; i++){
            if( sum % i == 0) return;
        }
        res++;
        return;
    }
    
}