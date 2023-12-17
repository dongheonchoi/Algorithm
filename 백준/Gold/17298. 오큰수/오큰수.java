import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
				
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[n];
		
		Stack<Integer> sta = new Stack<>(); 
		
		loop:
		for(int i = n-1; i >= 0 ; i--) {
			int a = arr[i];
			while (true) {
				if(sta.isEmpty()) {
					res[i] = -1;
					sta.push(a);
					continue loop;
				}else if(sta.peek() > a) {
					res[i] = sta.peek();
					sta.push(a);
					continue loop;
				}else {
					sta.pop();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			sb.append(res[i]+" ");
		}
		
		System.out.println(sb);
		
		
	}

}
