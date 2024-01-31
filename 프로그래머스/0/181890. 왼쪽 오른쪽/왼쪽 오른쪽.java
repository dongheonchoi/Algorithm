class Solution {
    public String[] solution(String[] str_list) {
        String[] res = {};
        
        for(int i = 0; i < str_list.length ; i++){
            
            if(str_list[i].equals("l")){
                res = new String[i];
                for(int j = 0; j < i; j++) {
                    res[j] = str_list[j];
                }
                return res;
            }else if(str_list[i].equals("r")){
                res = new String[str_list.length - i -1];
                int a = 0;
                for(int j = i+1; j < str_list.length; j++) {
                    res[a++] = str_list[j];
                }
                return res;
            }    
        }
                
        return res;
    }
}