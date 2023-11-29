import java.util.*;

public class Solution {
    public int solution(int n) {
        int res = 0;
    
        for(int i = 0; i < 9; i++){
            res += n%10;
            n/=10;
        }

        return res;
    }
}