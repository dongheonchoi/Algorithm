class Solution {
    public int solution(int num, int k) {
        String a = Integer.toString(num);
        char b = (char)(k+48);
        
        for(int i = 0; i < a.length() ; i++){
            if(a.charAt(i) == b) return (i+1);
        }
        
        
        
        return -1;
    }
}