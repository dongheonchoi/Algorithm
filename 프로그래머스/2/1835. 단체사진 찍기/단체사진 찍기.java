import java.util.*;
class Solution {
    static int[] arr , posi;
    static int res;
    static boolean[] tf;
    static String[] str;
    
    public int solution(int n, String[] data) {
        res = 0;
        //{A, C, F, J, M, N, R, T} -> 65, 67 , 70 , 74 , 77 , 78 , 82 , 84 -> 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7
        char[] cha = {'A', 'C', 'F', 'J', 'M','N', 'R', 'T'};
        arr = new int[85];
        posi = new int[8];
        tf = new boolean[8];
        str = data;
        
        // 이해하기 쉽게 각 프렌즈들의 idx를 저장   순서는 위의 주석을 따른다. ex) arr[A] == 0 번 인덱스
        for(int i = 0 ; i < 8; i++){
            arr[cha[i]] = i;    
        }
        
        fn(0);
        
        return res;
    }
    
    static void fn(int ii){
        if(ii == 8){
            check();
            return;
        }
        for(int i = 0; i < 8; i++){
            if(!tf[i]){
                posi[ii] = i;
                tf[i] = true;
                fn(ii+1);
                tf[i] = false;
            }
        }
    }
    
    static void check(){
        for(int i = 0; i < str.length; i++){
            char cha = str[i].charAt(3);
            int tem = Math.abs(posi[arr[str[i].charAt(0)]] - posi[arr[str[i].charAt(2)]])-1;
            if(cha == '='){
                if(tem == str[i].charAt(4)-'0'){
                }else{
                    return;
                }   
            }else if(cha == '>'){
                if(tem > str[i].charAt(4)-'0'){  
                }else{
                    return;
                }
            }else if(cha == '<'){
                if(tem < str[i].charAt(4)-'0'){
                }else{
                    return;
                }
            }
        }
        res++;
    }
    
    
}