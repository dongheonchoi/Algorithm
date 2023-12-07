import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        Integer[] arr = new Integer[score.length];
        
        if( k > score.length){
            k = score.length;
        }
        
        Arrays.fill(arr , -1);
        
        int[] res = new int[score.length];
        res[0] = score[0];
        arr[0] = score[0];
        
        int tem = score[0];
        for(int i = 1; i < k; i++){
            tem = Math.min(score[i], tem);
            arr[i] = score[i];
            res[i] = tem;
        }
        
        for(int i = k; i < score.length; i++){
            arr[i] = score[i];
            Arrays.sort(arr , Collections.reverseOrder());
            res[i] = arr[k-1];
        }

        return res;
    }
}