
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int res = 0;
				
		StringTokenizer st;
		st = new StringTokenizer(br.readLine() , " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(end >= b){
				continue;
			}
			else if(end >= a) {
				end = b;
			}else {
				res += end - start;
				start = a;
				end = b;
			}
			
		}
		res += end - start;
		
		System.out.println(res);
	}

}
