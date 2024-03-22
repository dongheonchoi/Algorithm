import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class beer implements Comparable<beer>{
		int v;
		int c;
		
		public beer(int v , int c) {
			this.v = v;
			this.c = c;
		}
		
		@Override
		public int compareTo(beer o) {
			return this.c-o.c;
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<beer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			pq.add(new beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int cnt = 0;
		int sum = 0;
		int min = 0;
		PriorityQueue<Integer> drink = new PriorityQueue<Integer>();
		while(!pq.isEmpty()) {
			beer tem = pq.poll();
			
			if(cnt < N) {
				cnt++;
				sum += tem.v;
				min = tem.c;
				drink.add(tem.v);
			}else {
				int a = drink.poll();
				sum -= a;
				sum += tem.v;
				min = tem.c;
				drink.add(tem.v);
			}
			if(sum >= M && cnt == N) {
				System.out.println(min);
				return;
			}
		}
		
		System.out.println(-1);
		
	}

}
