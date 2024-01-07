
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N ,res;
	static int[][] map;
	static boolean[][] tfMap;
	static ArrayList<ArrayList<node>> list;
	static int[] dR = {1 , 0 , -1 , 0};
	static int[] dC = {0 , 1 , 0 , -1};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		res = Integer.MAX_VALUE;
		map = new int[N][N];
		tfMap = new boolean[N][N];
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	
			}
		}
		
		list = new ArrayList<ArrayList<node>>();
		int idx = 0;
		for(int i = 0; i < N ; i++) {	
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !tfMap[i][j]) {
					tfMap[i][j] = true;
					list.add(new ArrayList<node>());
					list.get(idx).add(new node(i , j));
					dfs(i , j , idx++);
				}
			}
		}
		
		for(int i = 0; i < list.size()-1; i++) {
			ArrayList<node> aa = list.get(i);
			for(int ii = 0; ii < aa.size(); ii++) {
				node temN1 = aa.get(ii);
				for( int j = i+1; j < list.size() ; j++) {
					ArrayList<node> bb = list.get(j);
					for(int jj = 0; jj < bb.size(); jj++) {
						node temN2 = bb.get(jj);
						int tem = Math.abs(temN1.r-temN2.r)+Math.abs(temN1.c-temN2.c)-1;
						if( res > tem) {
							res = tem;
						}
					}
				}
				
			}
		}
		
		System.out.println(res);
				
	}

	private static void dfs(int r, int c, int idx) {
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dR[i];
			int nc = c + dC[i];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !tfMap[nr][nc] && map[nr][nc] == 1 ) {
				list.get(idx).add(new node(nr , nc));
				tfMap[nr][nc] = true;
				dfs(nr, nc , idx);
			}
		}	
	}
	
	static class node{
		int r;
		int c;
		public node(int r , int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}
