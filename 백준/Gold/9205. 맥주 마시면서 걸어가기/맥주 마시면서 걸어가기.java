import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class point{
	int x;
	int y;
	public point(int x, int y ) {
		this.x = x;
		this.y = y;
	
	}
}

public class Main {
	static int sPX , sPY , n;
	static boolean[] tf;
	static int[][] point;
	static StringBuilder sb;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < test_case; tc++) {
			n = Integer.parseInt(br.readLine());
			
			point = new int[n+1][2];
			tf = new boolean[n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			sPX = Integer.parseInt(st.nextToken());
			sPY = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			point[n][0] = Integer.parseInt(st.nextToken());
			point[n][1] = Integer.parseInt(st.nextToken());
			
			
			bfs();
			
		}
		
		System.out.println(sb);
		
	}

	private static void bfs() {
		Queue<point> que = new LinkedList<point>();
		
		que.add(new point(sPX, sPY));
		
		while(!que.isEmpty()) {
			point pp = que.poll();
			int temX = pp.x;
			int temY = pp.y;
			for(int i = n; i >= 0; i--) {
				
				if(!tf[i] && Math.abs(temX-point[i][0]) +Math.abs(temY-point[i][1])  <= 1000 ) {
					if(i == n) {
						sb.append("happy\n");
						return;
					}
					que.add(new point(point[i][0], point[i][1]));
					tf[i] =true;
				}
			}
		}
		
		sb.append("sad\n");
		return;
		
		
	}

}
