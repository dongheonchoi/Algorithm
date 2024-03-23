import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class node{
		int r;
		int c;
		public node(int r , int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N , L , R ,cnt ,sum , cunNum ,res;
	static ArrayList<ArrayList<node>> arr;
	static boolean[][] tf;
	static int[] dR = {0 , 1 , 0 , -1};
	static int[] dC = {1 , 0 , -1 , 0};
	static int[][] map;
	static boolean flag;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		flag = true;
		res = 0;
		while(flag) {
			flag = false;
			tf = new boolean[N][N];
			arr = new ArrayList<ArrayList<node>>();
			
			cnt = 0;
			for(int i = 0; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					if(!tf[i][j]) {
						sum = map[i][j];
						cunNum = 1;
						tf[i][j] = true;
						arr.add(new ArrayList<node>());
						arr.get(cnt).add(new node(i, j));
						bfs(i , j);
						arr.get(cnt++).add(new node(sum , cunNum));
					}
				}
			}
			if(flag) {
				res++;
			}
			
			for(int i = 0; i < arr.size(); i++) {
				ArrayList<node> tem = arr.get(i);
				int pop = tem.get(tem.size()-1).r / tem.get(tem.size()-1).c;
				for (int j = 0; j < tem.size()-1; j++) {
					map[tem.get(j).r][tem.get(j).c] = pop;
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println(" ");
		}

		System.out.println(res);
		
	
	}

	private static void bfs(int row, int col) {
		
		for (int i = 0; i < 4; i++) {
			int nr = row + dR[i];
			int nc = col + dC[i];
			if( nr < N && nr >= 0 && nc < N && nc >= 0 && !tf[nr][nc]) {
				int tt = Math.abs(map[row][col] - map[nr][nc]);
				if(tt >= L && tt <= R) {
					flag = true;
					arr.get(cnt).add(new node(nr , nc));
					sum += map[nr][nc];
					cunNum++;
					tf[nr][nc] = true;
					bfs(nr , nc);
				}
				
			}
			
		}
		
	}

}
