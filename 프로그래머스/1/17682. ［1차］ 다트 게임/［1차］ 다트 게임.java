class Solution {
    public int solution(String dartResult) {
        int res = 0;
        
        int[] score = new int[4];
        int dart = 0;
        
        for(int i = 0 ; i < dartResult.length(); i++){
            char a = dartResult.charAt(i);
            if( a >= 48 && 58 > a){
                dart++;
                if( a == 49 && dartResult.charAt(i+1) == '0'){
                    i++;
                    score[dart] = 10;
                }else{
                    score[dart] = a - 48;
                }                
            }else if(a == 'D'){
                score[dart] *= score[dart];
            }else if(a == 'T'){
                score[dart] *= score[dart]*score[dart];
            }else if(a == '*'){
                score[dart-1]*=2;
                score[dart]*=2;
            }else if(a == '#'){
                score[dart] *= -1;
            }
        }
        
        for(int i = 1 ; i < 4; i++){
            res += score[i];
        }
        
        return res;
    }
}