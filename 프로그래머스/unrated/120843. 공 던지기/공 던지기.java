class Solution {
    public int solution(int[] numbers, int k) {
        int a = numbers.length;
        
        return (2*(k-1))%a + 1;
        

    }
}