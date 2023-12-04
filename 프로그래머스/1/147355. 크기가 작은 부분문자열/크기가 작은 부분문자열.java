class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        
        long a = Long.parseLong(p);
        int res = 0;
        for(int i = 0; i < t.length() - len + 1; i++){
            long tem = Long.parseLong(t.substring(i , i+len));
            if(a >= tem) res++;
        }
    
        return res;
    }
}