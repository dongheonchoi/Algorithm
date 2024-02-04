import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int R , C;
	static int[][] map;
	static boolean[][] tfMap;
	static int[] dirR = {0,1,0,-1};
	static int[] dirC = {1,0,-1,0};
	static int tem = 0;
	static int cnt;
	static int res;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		tfMap = new boolean[R][C];
		
		
		for (int i = 0; i < R; i++) {
			st= new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 1 && !tfMap[i][j]) {
					cnt++;
					tfMap[i][j] = true;
					tem = 0;
					dfs(i,j);
					if(tem > res) res = tem; 
				}
			}
		}
		System.out.println(cnt);
		System.out.println(res);
	}

	private static void dfs(int i, int j) {
		tem++;
		
		for(int idx = 0; idx < 4; idx++) {
			int nR = i + dirR[idx];
			int nC = j + dirC[idx];
			if(nR >= 0 && nC >= 0 && nR < R && nC < C && !tfMap[nR][nC] && map[nR][nC] == 1) {
				tfMap[nR][nC] =true;
				dfs(nR, nC);
			}
		}
		
	}

}
