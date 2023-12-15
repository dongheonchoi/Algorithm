import java.util.*;
class Solution {
    static int len ,res;
    static int[] arr;
    static boolean[] tf;
    public int solution(int[] elements) {
        
        int [] arr = elements;
        int len = arr.length;
        int res = 0; 
        int sum = 0;
        for(int i  = 0; i < elements.length; i++){
            sum+=elements[i];
        }
        
        tf = new boolean[sum+1];
        int[] nE = new int[len*2];
        
        for(int i = 0 ; i < len; i++){
            nE[i] = nE[i+len] = elements[i];
        }
        
        for(int i = 0; i < len; i++){
            for(int j = 1; j <= len; j++){
                int tem = nE[i];
                for(int k = 1; k < j; k++){
                    tem += nE[i+k];
                }
                if(!tf[tem]){
                    res++;
                    tf[tem] = true;
                }
            }
        }
        
        return res;
    }

    
}