import java.util.*;
class Solution {
    public long solution(long n) {
        String str = n+"";
    
        char[] arr = new char[str.length()];
        
        for(int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i);
        }
        Arrays.sort(arr);
        
        String temp = "";
        
        for(int i = str.length()-1; i >= 0; i--){
            temp += arr[i];
        }
        
        long res = Long.parseLong(temp);
        
        return res;
    }
}