import java.util.*;
class Solution {
    public int[] solution(String[] gems) {

        int[] res = new int[2];

        HashMap<String , Integer> HM = new HashMap<>();

        for(int i = 0; i < gems.length; i++){
            HM.put(gems[i] , 0);
        }
        int size = HM.size()-1;
        
        int tem = Integer.MAX_VALUE;

        int start = 0;
        String startStr = gems[0];
        for(int i = 0; i < gems.length; i++ ){
            HM.put(gems[i], HM.get(gems[i]) + 1);
            if(!gems[i].equals(startStr)) {
                if(HM.get(gems[i]) == 1) {
                    size--;
                }
            } else {
                while(true){
                    int temNum = HM.get(gems[start]);
                    if(temNum >= 2){
                        HM.put(gems[start] , temNum-1);
                        start++;
                    }else {
                        startStr = gems[start];
                        break;
                    }
                }
            }
            if(size == 0 && tem > i-start){
                res[0] = start+1;
                res[1] = i+1;
                tem = i-start;
            }
        }
        return res;
    }
}