import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class hero{
	int r;
	int c;
	int time;
	boolean sword;
	public hero(int r, int c, int time, boolean sword) {
		this.r = r;
		this.c = c;
		this.time = time;
		this.sword = sword;
	}
	
}

public class Main {
	static int N,M,T;
	static int[][] map;
	static boolean [][][] tfMap;
	static int[] dR = {0,1,0,-1};
	static int[] dC = {1,0,-1,0};
	static boolean flag;
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tfMap = new boolean[2][N][M];
		flag = false;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move();	
		if (!flag) {
			System.out.println("Fail");
		}
		
	}



	private static void move() {
		Queue<hero> que = new LinkedList<hero>();
		
		que.add(new hero(0, 0, 0, false));
		tfMap[0][0][0] = true;
		
		while (!que.isEmpty()) {
			hero nH = que.poll();
			if (nH.time >= T) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nR = nH.r +  dR[i];
				int nC = nH.c +  dC[i];
//				System.out.println(nR + " " +nC);
				if (nR >= 0 && nR < N && nC >= 0 && nC < M) {
					if (nH.sword) {
						if(tfMap[1][nR][nC]) {
							continue;
						}else {
							if (nR == N-1 && nC == M-1) {
								System.out.println(nH.time+1);
								flag = true;
								return;
							}else {
								tfMap[1][nR][nC] = true;
								que.add(new hero(nR, nC, nH.time+1 , true));
							}
						}
					}else {
						if(tfMap[0][nR][nC] || tfMap[1][nR][nC] || map[nR][nC] == 1) {
							continue;
						}else {
							if (nR == N-1 && nC == M-1) {
								System.out.println(nH.time+1);
								flag = true;
								return;
							}else {
								if (map[nR][nC] == 2) {
									tfMap[0][nR][nC] = true;
									tfMap[1][nR][nC] = true;
									que.add(new hero(nR, nC, nH.time+1 , true));
								}else {									
									tfMap[0][nR][nC] = true;
									que.add(new hero(nR, nC, nH.time+1 , false));
								}
								
							}
						}
					}
				}
			}
		}
	}
}
