class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        sb.append(myString);
        
        for(int i = 0; i < myString.length();i++){
            char a = sb.charAt(i);
            if(a >= 65 && a<84) sb.replace(i , i+1 , (char)(a+32)+"");
        }

        return sb.toString();
    }
}