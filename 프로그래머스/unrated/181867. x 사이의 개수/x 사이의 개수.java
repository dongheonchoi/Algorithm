import java.util.*;
class Solution {
    public int[] solution(String myString) {
        String[] tem = myString.split("x");
        System.out.println(Arrays.toString(tem));
        int a = tem.length;
        int[] res;
        if(myString.charAt(myString.length()-1) == 'x'){
            res = new int[a+1];
            res[a] = 0;
        }else{
            res = new int[a];
        }
        
        for(int i = 0; i < a; i++){
            res[i] = tem[i].length();
        }
        
        
        return res;
    }
}