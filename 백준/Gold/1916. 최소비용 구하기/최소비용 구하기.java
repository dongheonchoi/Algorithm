import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class node implements Comparable<node>{
		int endPoint;
		int cost;
		public node(int endPoint, int cost){
			this.endPoint = endPoint;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static ArrayList<ArrayList<node>> arrList;
	static int start , end;
	static int[] arr;
	static boolean[] tf;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		
		arrList = new ArrayList<ArrayList<node>>();
		
		for(int i = 0; i < n+1; i++) {
			arrList.add(new ArrayList<node>());
		}
		
		for(int i = 0; i < bus; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arrList.get(a).add(new node(b, c));
		}
		
		StringTokenizer stt = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stt.nextToken());
		int end = Integer.parseInt(stt.nextToken());
		
		arr = new int[n+1];
		tf = new boolean[n+1];
		
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[start] = 0;
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		ArrayList<node> tem = arrList.get(start); 
		tf[start] = true;
		
		for(int i = 0; i < arrList.get(start).size(); i++) {
			pq.add(tem.get(i));
		}
		
		while(!pq.isEmpty()) {
			
			node nn = pq.poll();
			if(tf[nn.endPoint]) {
				continue;
			}
			tf[nn.endPoint] = true;
			
			ArrayList<node> tA = arrList.get(nn.endPoint);
			
			if(nn.endPoint == end) {
				System.out.println(nn.cost);
				break;
			}
			
			for(int i = 0; i < tA.size(); i++) {
				if(!tf[tA.get(i).endPoint]) {
					pq.add(new node(tA.get(i).endPoint, nn.cost + tA.get(i).cost));
				}
			}
		
		}
 		
	}

}
