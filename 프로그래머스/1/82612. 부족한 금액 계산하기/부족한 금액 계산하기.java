class Solution {
    public long solution(long price, long money, long count) {
        long res = money - price*(count*(count+1)/2);
        if(res < 0) return res*-1;
        else return 0;
    }
}