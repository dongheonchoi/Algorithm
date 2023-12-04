import java.util.*;
class Solution {
    public int solution(String s) {
        String[] arr = {"zero" , "one" , "two" , "three", "four", "five", "six", "seven", "eight", "nine"};
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) >=48 && sb.charAt(i) < 58) continue;
            
            for( int j = 0; j < 10; j++){
                if( i + arr[j].length() <= sb.length() && sb.substring(i, i + arr[j].length()).equals(arr[j])){
                    sb.replace(i, i + arr[j].length() , j+"");
                }
            }
            
        }
        
        
        return Integer.parseInt(sb.toString());
    }
}