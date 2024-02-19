import java.util.*;
class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(binomial , " ");
        
        int a = Integer.parseInt(st.nextToken());
        String bi = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        if(bi.equals("+")){
            return (a + b);
        }else if(bi.equals("-")){
            return (a - b);
        }else{
            return (a * b);
        }

    }
}