class Solution {
    public String solution(String[] seoul) {
        int n = 0;
        
        loop:
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")) {
                n = i;
                break loop;                           
            }
        }    
        return "김서방은 " + n + "에 있다";
    }
}