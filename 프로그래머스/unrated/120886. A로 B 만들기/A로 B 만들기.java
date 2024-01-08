import java.util.*;
class Solution {
    public int solution(String before, String after) {  // 97 ~ 122
        int answer = 1;
        
        int[] a = new int[26];
        int[] b = new int[26];
        
        for(int i = 0; i < before.length(); i++){
            a[before.charAt(i)-97]++;
        }
        for(int i = 0; i < after.length(); i++){
            b[after.charAt(i)-97]++;
        }
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]) {
                answer = 0;
                break;
            }
        }
        
        
        return answer;
    }
}