import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int R , C;
	static String[][] map;
	static boolean[][] tfMap;
	static int[] dirR = {0,1,0,-1};
	static int[] dirC = {1,0,-1,0};
	static int temO = 0;
	static int temV = 0;
	static int resO ,resV;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		tfMap = new boolean[R][C];
		resO = 0;
		resV = 0;
		
		for (int i = 0; i < R; i++) {
			String[] arr = br.readLine().split("");
			map[i] = Arrays.copyOf(arr, C);
		}
		
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(!map[i][j].equals("#") && !tfMap[i][j]) {
					tfMap[i][j] = true;
					temO = 0;
					temV = 0;
					dfs(i,j);
					if(temO <= temV) {
						resV += temV;
					}else {
						resO += temO;
					}
				}
			}
		}
		System.out.println(resO + " " + resV);
		
	}

	private static void dfs(int i, int j) {
		if(map[i][j].equals("v")) temV++;
		else if(map[i][j].equals("o")) temO++;
		
		for(int idx = 0; idx < 4; idx++) {
			int nR = i + dirR[idx];
			int nC = j + dirC[idx];
			if(nR >= 0 && nC >= 0 && nR < R && nC < C && !tfMap[nR][nC] && !map[nR][nC].equals("#") ) {
				tfMap[nR][nC] =true;
				dfs(nR, nC);
			}
		}
		
		
	}

}
