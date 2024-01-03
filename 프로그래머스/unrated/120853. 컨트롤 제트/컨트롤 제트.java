class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        int res = 0;
        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i].equals("Z")){
                i--;
            }else{
                res += Integer.parseInt(arr[i]);
            }
        }
        return res;
    }
}