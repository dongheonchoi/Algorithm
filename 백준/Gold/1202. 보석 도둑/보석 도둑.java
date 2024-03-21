import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class jew implements Comparable<jew>{
		int weight;
		int value;
		public jew(int weight , int value){
			this.weight = weight;
			this.value = value;
		}
		@Override
		public int compareTo(jew o) {
			return this.weight - o.weight;
		}
		
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<jew> list = new ArrayList<>();
					
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			list.add(new jew(weight, val));
		
		}
		
		list.sort((o1 ,o2) -> o1.weight-o2.weight);
		
		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		int idx = 0;
		long res = 0;
		boolean flag = true;
		for (int i = 0; i < K; i++) {
			int temW = bag[i];
			while(flag) {
				if(idx == N) {
					flag = false;
					break;
				}
				if(list.get(idx).weight > temW ) break;
				
				pq.add(list.get(idx++).value);
			}
			
			if(!pq.isEmpty()) {
				res+=pq.poll();
			}
			
		}
		
		System.out.println(res);
		
	}
		

}
