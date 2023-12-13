class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        System.out.println(queries[0][0]+" " + queries[0][1] + " " + queries[0][2]);
        
        for(int i = 0; i < queries.length; i++){
            int min = 987654321;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if(arr[j] > queries[i][2]) 
                    min = Math.min(arr[j], min);
            }
            if(min == 987654321) answer[i] = -1;
            else answer[i] = min;
        }
        
        return answer;
    }
}