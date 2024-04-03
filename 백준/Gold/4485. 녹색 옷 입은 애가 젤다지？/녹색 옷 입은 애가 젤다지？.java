import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class node implements Comparable<node>{
		int r;
		int c;
		int sum;
		public node(int r, int c , int sum) {
			this.r = r;
			this.c = c;
			this.sum = sum;
		}
		@Override
		public int compareTo(node o) {
			return this.sum - o.sum;
		}
	}
	static int[][] coin , map;
	static int flag , res;
	static int[] dirR = {0 , 1, -1, 0};
	static int[] dirC = {1, 0, 0 , -1};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = 1;
		while(true) {
			flag = Integer.parseInt(br.readLine());
			if(flag == 0) {
				break;
			}
			
			coin = new int[flag][flag];
			map = new int[flag][flag];
			res = Integer.MAX_VALUE;
			
			for(int i = 0; i < flag; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine() , " ");
				for (int j = 0; j < flag; j++) {
					coin[i][j] = Integer.parseInt(st.nextToken());	
				}
			}
			
			for(int i = 0; i < flag; i++) {
				Arrays.fill(map[i], Integer.MAX_VALUE);
			}
			
			map[0][0] = coin[0][0];
			
			PriorityQueue<node> pq = new PriorityQueue<>();
			pq.add(new node(0, 0, map[0][0]));
			
			here:
			while(!pq.isEmpty()) {
				node nn = pq.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = nn.r + dirR[i];
					int nc = nn.c + dirC[i];
					if(nr >=0 && nr < flag && nc >=0 && nc < flag && map[nr][nc] > nn.sum + coin[nr][nc]) {
						if(nr == flag-1 && nc == flag-1) {
							res = nn.sum + coin[nr][nc];
							break here;
						}
						map[nr][nc] = nn.sum + coin[nr][nc];
						pq.add(new node(nr , nc , nn.sum + coin[nr][nc]));
					}
				}
				
			}
			
			sb.append("Problem " + test_case++ +": " + res +"\n");
			
		}
		System.out.println(sb);
	}

}
