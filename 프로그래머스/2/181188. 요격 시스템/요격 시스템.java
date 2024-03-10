import java.util.*;
class Solution {
    public int solution(int[][] targets) {
		Arrays.sort(targets, (a, b) -> {
			return a[1] - b[1];
		});
		int res = 0;
		int tem = -1;
		for(int i = 0; i < targets.length; i++) {
			
			if(tem <= targets[i][0]) {
				tem = targets[i][1];
				res++;
			}
		}
        return res;
    }
}