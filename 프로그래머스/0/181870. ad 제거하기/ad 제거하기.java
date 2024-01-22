class Solution {
    public String[] solution(String[] strArr) {
        boolean[] tf = new boolean[strArr.length];
        
        int cnt = strArr.length;
        
        for(int i = 0 ; i < strArr.length; i++ ){
            if(strArr[i].contains("ad")){
                tf[i] = true;
                cnt--;
            }
        }
        
        String[] res = new String[cnt];
        
        int idx = 0;
        for(int i = 0; i < tf.length; i++){
            if(!tf[i]){
                res[idx++] = strArr[i];
            }
        }
        
        
        return res;
    }
}