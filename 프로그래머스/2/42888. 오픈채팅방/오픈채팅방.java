import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<String, String>();
        
        int cnt = 0; 
        
        for(int i = 0; i < record.length; i++){
            String[] tem = record[i].split(" ");
            
            if(tem[0].equals("Leave")){       
                continue;
            } else if (tem[0].equals("Enter")){
                hm.put(tem[1], tem[2]);
            } else {                           
                hm.put(tem[1], tem[2]);
                cnt++;
            }
        }        
        
        String[] answer = new String[record.length - cnt];
        
        int ii = 0; 
        for(int i = 0 ; i < record.length; i++){
            String[] tem = record[i].split(" ");
            if(tem[0].equals("Change")){       
              continue;
            } else if (tem[0].equals("Enter")){
              answer[ii++] = hm.get(tem[1]) + "님이 들어왔습니다.";
            } else {                           
              answer[ii++] = hm.get(tem[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}