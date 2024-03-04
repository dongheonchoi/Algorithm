import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dR = {-1 , 0 , 1 , 0};
	static int[] dC = {0 , -1 , 0 , 1};
	static HashMap<Character, Boolean> hm;
	static char[][] map;
	static int R , C , res;

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		hm = new HashMap<Character, Boolean>();
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char cha = str.charAt(j);
				map[i][j] = cha;
				hm.put(cha, false);
			}
		}
		
		hm.put(map[0][0] ,true);
		dfs(0 , 0 , 1);
		
		System.out.println(res);
	}

	private static void dfs(int r, int c, int cnt) {
		
		for(int i = 0; i < 4; i++) {
			int nr = r+dR[i];
			int nc = c+dC[i];
			
			if(nr >= 0 && nc>=0 && nr < R && nc < C && !hm.get(map[nr][nc])) {
				hm.put(map[nr][nc] ,true);
				dfs(nr ,nc ,cnt+1);
				hm.put(map[nr][nc] ,false);
			}
			
		}
		
		if(cnt > res) {
			res = cnt;
		}
		
	}

}
