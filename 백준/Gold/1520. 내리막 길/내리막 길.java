import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R ,C ,res;
	static int[][] map;
	static int[][] dpMap;
	static int[] dR = {1,0,-1,0};
	static int[] dC = {0,1,0,-1};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		res = 0;
		
		map = new int[R][C];
		dpMap = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dpMap[i][j] = -1;
			}
		}
		
		System.out.println(go(0 , 0 , map[0][0]));
		
	}

	private static int go(int r, int c, int num) {
//		System.out.println("r : " +r +" c : "+ c + " num : " + num);
		if (dpMap[r][c] != -1) {
			return dpMap[r][c]; 
		}
		if (r == R-1 && c == C-1) {
			return 1;
		}
		dpMap[r][c] = 0;
		
		
		for (int i = 0; i < 4; i++) {
			int nR = r + dR[i];
			int nC = c + dC[i];
			if (nR >= 0 && nR < R && nC >= 0 && nC < C && num > map[nR][nC]) {
				dpMap[r][c] += go(nR, nC, map[nR][nC]);
			}
		}
		return dpMap[r][c];
	}
}
