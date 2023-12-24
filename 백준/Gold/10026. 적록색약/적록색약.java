

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int a ,res1, res2;
	static String[][] map;
	static boolean[][][] tf;
	static int[] dR = {0,1,0,-1};
	static int[] dC = {1,0,-1,0};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = Integer.parseInt(br.readLine());
		map = new String[a][a];
		
		for(int i = 0; i < a; i++) {
			map[i] = br.readLine().split("");
		}
		
		tf = new boolean[2][a][a];		
		
		res1 = 0;
		res2 = 0;
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
//				System.out.println("좌표 : "+ i + " " + j);
				if(!tf[0][i][j]) {
//					System.out.println(i + " " + j);
					res1++;
					if(!tf[1][i][j]) {
						res2++;
					}
					tf[0][i][j] = true;
					tf[1][i][j] = true;
					bfs(i , j , map[i][j]);
				}
			}
		}
		System.out.println(res1 + " " + res2);
		
	}

	private static void bfs(int r, int c, String string) {
		
		if(string.equals("B")) {
			for(int i = 0; i < 4; i++) {
				int nr = r + dR[i];
				int nc = c + dC[i];
				if(nr >=0 && nr < a && nc >=0 && nc < a && !tf[0][nr][nc] && map[nr][nc].equals("B") ) {
					tf[0][nr][nc] = true;
					tf[1][nr][nc] = true;
					bfs(nr, nc , string);
				}
			}
		}else {
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dR[i];
				int nc = c + dC[i];
				if(nr >=0 && nr < a && nc >=0 && nc < a && !tf[0][nr][nc] && !map[nr][nc].equals("B") ) {

					if(map[nr][nc].equals(string)) {
						
						tf[0][nr][nc] = true;
						tf[1][nr][nc] = true;
						bfs(nr, nc , string);

					}else {
						if(!tf[1][nr][nc]) {
							tf[1][nr][nc] = true;
							bfs(nr, nc , "F");
						}
					}
				}
			}
		}
	}

}
