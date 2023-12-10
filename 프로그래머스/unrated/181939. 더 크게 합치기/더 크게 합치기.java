class Solution {
    public int solution(int a, int b) {
        if(a == b) return Integer.parseInt(a+""+b);
        String c = a+""+b;
        String d = b+""+a;
        for(int i = 0 ; i < c.length(); i++){
            if(c.charAt(i) > d.charAt(i)) return Integer.parseInt(c);
            else if(c.charAt(i) < d.charAt(i)) return Integer.parseInt(d);
        }
        return 0;
    }
}