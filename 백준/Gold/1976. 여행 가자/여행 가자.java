import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N , M ;
	static int[][] map;
 	static boolean[] tf1 , tf2;
 	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		tf1 = new boolean[N+1];
		tf2 = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		tf1[a] = true;
		for (int i = 0; i < M-1; i++) {
			int b = Integer.parseInt(st.nextToken());
			tf1[b] = true;
		}
		
		tf2[a] = true;
		bfs(a);
		
		boolean flag = true;
		int cnt = 0;
		for (int i = 0; i <= N; i++) {
			if (tf1[i] && !tf2[i]) {
				flag = false;
				break;
			}
			
		}
		
		if (flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

	private static void bfs(int a) {
		for (int i = 0; i <= N; i++) {
			if (map[a][i] == 1 && !tf2[i]) {
				tf2[i] = true;
				bfs(i);
			}
		}
	}

}
