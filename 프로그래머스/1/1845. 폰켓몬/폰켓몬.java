class Solution {
    public int solution(int[] nums) {
        boolean[] arr = new boolean[200001];
        
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(!arr[nums[i]]){
                arr[nums[i]] = true;
                cnt++;
            }
        }
        if(cnt > nums.length/2){
            return nums.length/2;
        }else{
            return cnt;
        }

    }
}