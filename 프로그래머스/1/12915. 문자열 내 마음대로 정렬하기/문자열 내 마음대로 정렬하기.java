import java.util.*;
class Solution {
    public String[] solution(String[] str, int n) {     
        Arrays.sort(str , (a ,b) -> {
                    if(a.charAt(n)-b.charAt(n) == 0){
                        int len = Math.min(a.length(), b.length());
                        for(int i = 0 ; i < len; i++){
                            if(a.charAt(i)-b.charAt(i) != 0){
                                return a.charAt(i)-b.charAt(i);
                            } 
                        }
                        return a.length() - b.length();
                    }else{
                        return a.charAt(n)-b.charAt(n);
                    }});
        return str;
    }
}