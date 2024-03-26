import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		int hi = 0;
		int lo = 0;
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			hi += a;
			arr[i] = a;
			lo = Math.max(lo, a);

		}
		
		
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			
			int tem = 0;
			int sum = 0;
			for(int i = 0 ;  i < N ; i++) {
				sum+=arr[i];
				if(sum > mid) {
					sum = 0;
					tem++;
					i--;
				}
				
			}
			
			if(sum!=0) {
				tem++;
			}
			
			if (tem > M) {
				lo = mid+1;
			}else {
				hi = mid-1;				
			}
						
		}
		System.out.println(lo);

	}

}
