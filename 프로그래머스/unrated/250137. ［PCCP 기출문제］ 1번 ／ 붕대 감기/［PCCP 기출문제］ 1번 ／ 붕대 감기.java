class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int[] a = new int[attacks[attacks.length-1][0]+1 ];
        
        
        for(int i = 0 ; i < attacks.length; i++){
            a[attacks[i][0]] = attacks[i][1];
        }
        
        
        int nH = health;
        int cnt = 0;
        for(int i = 0 ; i < a.length; i++){
            cnt++;
            if(a[i] != 0){
                cnt = 0;
                nH -= a[i];  
                if(nH <= 0) return -1;
            }else if( cnt == bandage[0]){
                cnt = 0;
                nH += bandage[1];
                nH += bandage[2];
            }else{
                nH += bandage[1];
            }
                if(nH > health) nH = health;
        }
        
        
        
        return nH;
    }
}