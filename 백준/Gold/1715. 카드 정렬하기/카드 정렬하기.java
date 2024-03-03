import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		
		int res = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < len; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i = 0; i < len-1; i++) {
			int a = pq.poll();
			int b = pq.poll();
			int c = a + b;
			res += c;
			pq.add(c);
		}
		System.out.println(res);
		
	}

}
