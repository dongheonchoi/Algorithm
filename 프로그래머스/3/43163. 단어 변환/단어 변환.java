import java.util.*;

class bag{
    String word;
    int cnt;
    public bag(String word , int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    static String start , end;
    static String[] arr;
    static int len;
    static boolean[] tf;
    
    public int solution(String begin, String target, String[] words) {
        
        start = begin;
        end = target;
        arr = words;
        len = begin.length();
        tf = new boolean[words.length];
        
        return bfs();
    }
    
    static int bfs(){
        Queue<bag> que = new LinkedList<>();
        
        que.add(new bag(start , 0));
        
        while(!que.isEmpty()){
            bag nb = que.poll();
            String ns = nb.word;
            
            for(int i = 0; i < arr.length; i++){
                if(!tf[i]){
                    String tem = arr[i];
                    int tc = 0;
                    for(int j = 0 ; j < len; j++){
                        if(ns.charAt(j) == tem.charAt(j)) tc++;
                    }
                    if(tc == len-1){
                        if(tem.equals(end)) return nb.cnt+1;
                        else que.add(new bag(tem , nb.cnt+1));
                        tf[i] = true;
                    }
                    
                }
            }
            
            
            
        }
        
        return 0;
        
        
    }
    
    
}