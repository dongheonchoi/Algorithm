class Solution {
    public String solution(String my_string, int s, int e) {
        String str = my_string.substring(s,e+1);

        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String nStr = sb.reverse().toString();

        my_string = my_string.replaceAll(str, nStr);
        return my_string;
    }
}