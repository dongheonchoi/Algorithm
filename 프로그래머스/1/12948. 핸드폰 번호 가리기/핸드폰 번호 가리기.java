class Solution {
    public String solution(String phone_number) {
       
        String star = "*";
        String s = "";
        s = star.repeat(phone_number.length()-4);
        s += phone_number.substring(phone_number.length()-4,phone_number.length());
        return s;
    }
}