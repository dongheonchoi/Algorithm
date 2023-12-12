class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        boolean flag = true;
        for(int i = 0; i < s.length(); i++){
            char a = sb.charAt(i);
            if( a == ' '){
                flag =true;
                continue;
            } 
            
            if(flag){
                flag = false;
                if(a >= 97 && a < 123){
                    a -= 32;
                    sb.replace(i, i+1 , ""+a);
                }
            }else{
                if(a >= 65 && a < 91){
                    a += 32;
                    sb.replace(i, i+1 , ""+a);
                }
            }         
        }
        
        return sb.toString();
    }
}