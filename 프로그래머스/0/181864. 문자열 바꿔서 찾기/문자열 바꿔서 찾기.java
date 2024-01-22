class Solution {
    public int solution(String myString, String pat) {
        
        pat = pat.replace("A" , "C");
        pat = pat.replace("B" , "A");
        pat = pat.replace("C" , "B");
        
        if(myString.contains(pat)){
            return 1;
        }else{
            return 0;
        }
        
    }
}