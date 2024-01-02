class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        if( arr1.length > arr2.length) return 1;
        else if( arr1.length < arr2.length) return -1;
        else{
            int a = 0;
            int b = 0;

            
            for(int i = 0; i < arr1.length; i++){
                if(arr1[i] != arr2[i]){
                    a += arr1[i];
                    b += arr2[i];
                }
                
            }
            if( a > b) return 1;
            else if( a < b) return -1;
            else return 0;
             
        }
        


    }
}