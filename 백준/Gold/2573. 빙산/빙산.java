import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class node{
	int r;
	int c;
	int wCnt;
	public node(int r, int c, int wCnt) {
		super();
		this.r = r;
		this.c = c;
		this.wCnt = wCnt;
	}
	public int getwCnt() {
		return wCnt;
	}
	public void setwCnt(int wCnt) {
		this.wCnt = wCnt;
	}
	
}

public class Main {
	static int[][] map;
	static int N, M , res;
	static ArrayList<node> arr;
	static int[] dR = {0,1,0,-1};
	static int[] dC = {1,0,-1,0};
	static boolean[][] tfMap;
	static boolean flag;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " "); 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		arr = new ArrayList<node>();
		res = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a != 0) {
					map[i][j] = a;
					arr.add(new node(i, j , 0));
				}

			}
		}
		

		
		while(!flag) {
			res++; // 시간이 흐르는걸 세는 부분
			melt(); // 빙하가 녹는 메서드
			count(); // 빙하의 덩어리를 카운트
		}
		
		
		System.out.println(res);
		
	}

	private static void melt() {
		int a =  arr.size()-1;
		
		if (arr.size() == 0) {
			res = 0;
			flag = true;
			return;
		}
		
		
		for (int i = a; i >= 0; i--) {
			int wCnt = 0;
			node nN = arr.get(i);
			
			for (int j = 0; j < 4; j++) {
				if(map[nN.r+dR[j]][nN.c+dC[j]] <= 0) {
					wCnt++;
				}
			}
			arr.get(i).setwCnt(wCnt);
		}
		
		for (int i = a; i >= 0; i--) {
			node nN = arr.get(i);
			map[nN.r][nN.c] -= nN.getwCnt();
			if( map[nN.r][nN.c] <= 0) {
				arr.remove(i);
			}
			
		}
		
		
	}

	private static void count() {
		tfMap = new boolean[N][M];
		int cnt = 0 ; 
		for (int i = 0; i < arr.size(); i++) {
			node nN = arr.get(i);
			if (!tfMap[nN.r][nN.c]) {
				cnt++;
				dfs(nN.r, nN.c);
			}
		}
		if (cnt >= 2) {
			flag = true;
		}
	}

	private static void dfs(int r , int c) {
		tfMap[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nR = r + dR[i];
			int nC = c + dC[i];
			if (map[nR][nC] > 0 && !tfMap[nR][nC]) {
				dfs(nR, nC);
			}
		}
		
	}

}
