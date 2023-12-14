class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] res = new int[2];
        for(int i = 1; i <= 2000000; i++ ){
            for(int j = 1; j <= i; j++){
                if(i * j == yellow && (i+2)*(j+2)-yellow == brown){
                    res[0] = i+2;
                    res[1] = j+2;
                    return res;
                }else if(i * j > yellow) {
                    break;
                }
            }
        }

        return res;
    }
}