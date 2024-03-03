import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class castle{
	int height;
	int idx;
	public castle(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}
}

public class Main {
	

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int len = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Stack<castle> stack = new Stack<castle>();
		
		for(int i = 0; i < len; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			while(true) {
				if(!stack.isEmpty()) {
					if(stack.peek().height > a) {
						sb.append(stack.peek().idx + " ");
						break;
					}else {
						stack.pop();
					}
				}else {
					sb.append(0 + " ");
					break;
				}
			}
			stack.add(new castle(a, i+1));
		}

		System.out.println(sb);
	}

}
