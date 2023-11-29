class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        int s1 = 0;
        int s2 = 0;
        
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(a == 'p'|| a == 'P') s1++;
            else if(a == 'y'|| a == 'Y') s2++;
        }
        if(s1 == s2) answer = true;

        return answer;
    }
}