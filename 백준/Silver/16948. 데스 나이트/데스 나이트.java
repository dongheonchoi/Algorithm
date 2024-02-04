import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node{
	int r;
	int c;
	int cnt;
	public node(int r , int c , int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main {
	
	static String[][] map;
	static boolean[][] tfMap;
	static int[] dirR = {-2,-2,0,0,2,2};
	static int[] dirC = {-1,1,-2,2,-1,1};
	static int N ,a , b , r , c , res;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		res = -1;
		
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		Queue<node> que = new LinkedList<node>();
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		que.add(new node(a, b , 0));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		tfMap = new boolean[N][N];
		tfMap[a][b] = true;
		
		flag :
		while (!que.isEmpty()) {
			node nn = que.poll();
			for(int i = 0; i < 6; i++) {
				int nR = nn.r + dirR[i];
				int nC = nn.c + dirC[i];
				if( nR >=0 && nC >= 0 && nR < N && nC < N && !tfMap[nR][nC]) {
					tfMap[nR][nC] = true;
					if (nR == r && nC == c) {
						res = nn.cnt+1;
						break flag;
					}
					que.add(new node(nR, nC , nn.cnt+1));
				}
			}
		}
		
		System.out.println(res);
		
	}


}
