
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, res ,tem;
	static int[][] Map;
	static boolean[][] tfMap;
	static int[] dR = {0,0,1,1,1,-1,-1,-1};	//8방
	static int[] dC = {1,-1,1,-1,0,1,-1,0};	
	static boolean flag;
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N][M];
		tfMap = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!tfMap[i][j]) {
					tem = Map[i][j];
					tfMap[i][j] = true;
					flag = false;
					dfs(i , j);
					if(!flag) {
						res++;
					}
				}
			}
		}
		
		System.out.println(res);
		
	}


	private static void dfs(int r, int c) {
		for(int i = 0; i < 8; i++) {
			int nR = r + dR[i];
			int nC = c + dC[i];
			if( nR >=0 && nR < N && nC >= 0 && nC < M) {
				if(Map[nR][nC] == tem && !tfMap[nR][nC]) {
					tfMap[nR][nC] = true;
					dfs(nR, nC);
				}else if(Map[nR][nC] > tem ){
					flag = true;
				}
				
			}
			
			
		}
		
	}

	

}
