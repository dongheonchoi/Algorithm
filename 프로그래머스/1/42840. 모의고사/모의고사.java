import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5}; // 5
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        
        for(int i = 0; i < answers.length; i++){
            int tem = answers[i];
            if(tem == p1[i%5]) a1++;

            if(tem == p2[i%8]) a2++;
            
            if(tem == p3[i%10]) a3++;
        }
        
        int[] score = {a1 , a2 , a3};
        
        Arrays.sort(score);
        
        int cnt  = 1;
        
        if(score[2] == score[1]) cnt++;
        if(score[2] == score[0]) cnt++;
        
        int[] res = new int[cnt];
        
        int idx = 0;
        if(a1 == score[2]){
            res[idx++] = 1;
        }
        if(a2 == score[2]){
            res[idx++] = 2;
        }
        if(a3 == score[2]){
            res[idx++] = 3;
        }
        
        return res;
    }
}