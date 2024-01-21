	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;

	class node{
		int r;
		int c;
		int z;
		public node(int r , int c, int z) {
			this.r = r;
			this.c = c;
			this.z = z;
		}
	}

	public class Main {
		static int r , c, z , cnt , time;
		static Queue<node> que;
		static int[][][] map;
		static boolean[][][] tfMap;
		static int[] dR = {-1, 0, 1, 0 , 0 , 0};
		static int[] dC = {0, 1, 0, -1 , 0 , 0};
		static int[] dZ = {0, 0, 0, 0 , 1 , -1};
		
		public static void main(String[] args)throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			map = new int[z][r][c];
			cnt = 0;
			time = -1;
			
			que = new LinkedList<node>();
			
			for (int i = 0; i < z; i++) {
				for (int j = 0; j < r; j++) {
					st =  new StringTokenizer(br.readLine() ," ");
					for (int j2 = 0; j2 < c; j2++) {
						int num = Integer.parseInt(st.nextToken());
						map[i][j][j2] = num;
						if (num == 0) {
							cnt++;
						}else if (num == 1) {
							node nod = new node(j , j2 , i); 
							que.add(nod);
						}
					}
				}
			}
			
			BFS();
			if (cnt != 0) {
				System.out.println(-1);
			}else {
				System.out.println(time);
			}
		}
		
		static void BFS() {
			int num = que.size(); 
			while (!que.isEmpty()) {
				node nn =  que.poll();
				num--;
				if (num == 0) { 
					time++;
				}

				for (int i = 0; i < 6; i++) {
					int nR = nn.r + dR[i];
					int nC = nn.c + dC[i];
					int nZ = nn.z + dZ[i];
					if (nR >= 0 && nR < r && nC >= 0 && nC < c && nZ >= 0 && nZ < z && map[nZ][nR][nC] == 0 ) {
						cnt--;		
						map[nZ][nR][nC] = 1;
						node n2 = new node(nR, nC ,nZ);
						que.add(n2);
					}
				}
				if (num == 0) {  
					num = que.size();
				}	
			}
		}
	}

