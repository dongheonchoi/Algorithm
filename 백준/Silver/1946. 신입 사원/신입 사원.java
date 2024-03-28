import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc= 0; tc < test_case; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N+1];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				arr[a] = Integer.parseInt(st.nextToken());
			}
			
			int tem = 0;
			int a = arr[1];
			for (int i = 2; i <= N; i++) {
				if(a < arr[i]) {
					tem++;
				}else {
					a = arr[i];
				}
			}
			sb.append(N-tem).append("\n");
			
		}
		System.out.println(sb);
	}
	
	
}
