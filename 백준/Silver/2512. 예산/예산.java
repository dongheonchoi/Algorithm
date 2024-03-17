import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int hi = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i <= N-1 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hi = Math.max(hi, arr[i]);
		}
		
		int budget = Integer.parseInt(br.readLine());

		int lo = 1;
		
		while (lo <= hi) {
			int mid = (lo + hi)/2;
			int num = budget;
			
			for (int i = 0; i < N; i++) {
				if (mid >= arr[i]) {
					num -= arr[i];
				}else {
					num -= mid;
				}
			}
			if (num >= 0) {
				lo = mid+1;
			}else {
				hi = mid-1;				
			}
		}
		
		System.out.println(hi);
		
	}

}
