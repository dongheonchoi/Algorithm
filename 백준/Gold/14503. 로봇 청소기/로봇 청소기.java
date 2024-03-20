import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dR = {-1,0,1,0};
	static int[] dC = {0,1,0,-1};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		
		int[][] map = new int[N][M];
		boolean[][] tf = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < M; j++) {
				int tem = Integer.parseInt(st.nextToken());
				map[i][j] = tem;
				if(tem == 1) {
					tf[i][j] = true;
				}
			}
			
		}
		
		int res = 0;
		
		loof:
		while(true) {
			
			if(!tf[r][c]) {
				res++;
				tf[r][c] = true;
			}
			
			boolean clean = false;
			for(int i = 0; i < 4; i++) {
				if(!tf[r + dR[i]][c + dC[i]]) {
					clean = true;
					break;
				}
			}
			
			if(!clean) {
				r += dR[(d + 2) % 4];
				c += dC[(d + 2) % 4];
				if(map[r][c] == 1) break;
				continue;
			}else {
				for(int i = 0; i < 4; i++) {
					d = (3 + d) % 4;
					if(!tf[r +  dR[d]][c + dC[d]]) {						
						r += dR[d];
						c += dC[d];
						continue loof;
					}

				}
				
			}
			
		}
		
		System.out.println(res);
				
	}

}
