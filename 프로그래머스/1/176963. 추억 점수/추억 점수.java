import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] res = new int[photo.length];
        
        HashMap<String,Integer> HM = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            HM.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(int j = 0;j <photo[i].length; j++){
                sum += HM.getOrDefault(photo[i][j],0);
            }
            res[i] = sum;
        }
        
        
        
        return res;
    }
}