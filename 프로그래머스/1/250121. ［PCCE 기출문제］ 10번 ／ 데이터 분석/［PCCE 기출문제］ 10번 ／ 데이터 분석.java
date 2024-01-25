import java.util.*;
class Solution {
    static int a ,b;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        a = -1;
//         HashMap<String , int> hash = new HashMap<String, int>();      
//         hash.set("code" , 0);
//         hash.set("date" , 1);
//         hash.set("maximum" , 2);
//         hash.set("remain" , 3);
        
        if(ext.equals("code")) a=0;
        else if(ext.equals("date")) a=1;
        else if(ext.equals("maximum")) a=2;
        else a=3;
        
        int idx = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i][a] < val_ext) idx++;
        }
        
        if(sort_by.equals("code")) b=0;
        else if(sort_by.equals("date")) b=1;
        else if(sort_by.equals("maximum")) b=2;
        else b=3;
        
        Arrays.sort(data , (o1 , o2) -> {
            return o1[b]-o2[b];
        });
        
        int[][] answer = new int[idx][4];
        
        int cnt = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i][a] < val_ext) answer[cnt++] = data[i];
        }
        
        return answer;
    }
}