class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int cnt = 0;
        String[] tem = new String[todo_list.length];
        
        for(int i = 0; i < todo_list.length; i++){
            if(!finished[i]){
                tem[cnt] = todo_list[i];
                cnt++;
            }
        }
        
        String[] res = new String[cnt];
        
        for(int i = 0; i < cnt ; i++){
            res[i] = tem[i];
        }
            
        return res;
    }
}