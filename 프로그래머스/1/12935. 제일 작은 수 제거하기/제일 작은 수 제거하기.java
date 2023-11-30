import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        if(arr.length == 1 ) return answer; 
       
        int[] res = new int[arr.length-1];
        
        int[] clone = new int[arr.length];
        for(int i = 0; i < arr.length; i++ ){
            clone[i] = arr[i];
        }
        
        Arrays.sort(arr);
        
        int a = arr[0];
        
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++ ){
            if(clone[i] != a){
                res[idx++] = clone[i];
            }
        }
        
        return res;
    }
}