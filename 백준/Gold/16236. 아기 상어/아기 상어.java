import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark{
	int r;
	int c; 
	int dist;
	public Shark(int r , int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
}


public class Main {
	static int sharkR ,sharkC , level, need ,N ,res;
	static int[] dR = { 1, 0, -1, 0};
	static int[] dC = { 0, 1, 0, -1};
	static int[][] map; 
	static boolean[][] tfMap; 
	static ArrayList<Shark> eat;
	
	public static void main(String[] args)throws IOException { // que 안에 들어갈 클래스에 필요한 것 이동한 거리? 좌표 ? 먹는 순간 이동한 거리와 level 계산후  que clear?
															   // 레벨이 같을 때와 낮을 때 구분해서 해주기 // 한번 사이클이 돌때 먹은것들 전부 저장해 두기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		level = 2;
		need = 2;
		res = 0;
		
		map = new int[N][N];
		tfMap = new boolean[N][N];
		eat = new ArrayList<Shark>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkR = i;
					sharkC = j;
					map[i][j] = 0;
				}
			}
		}
		
		BFS();
		
		System.out.println(res);
		
		
		
	}
	
	static void BFS(){
		Queue<Shark> info = new LinkedList<Shark>();
		Shark shark = new Shark(sharkR, sharkC, 0);
		info.add(shark);
		
		int cnt = 1;
		while (!info.isEmpty()) {
			cnt--; 
			/////////////////////////////////////////////////////////////////////////////////////////////////////언제를 한 사이클로 볼것인지
			
			
			
			shark = info.poll();
			tfMap[shark.r][shark.c] = true;
			
			
			
			for (int i = 0; i < 4; i++) {
				int nr = shark.r + dR[i];
				int nc = shark.c + dC[i];
				int ndist = shark.dist + 1;

				
				Shark newS = new Shark(nr, nc, ndist);

				if ( nr >= 0 && nc >= 0 && nr < N && nc < N && !tfMap[nr][nc] && map[nr][nc] <= level ) {
					if (map[nr][nc] < level && map[nr][nc] != 0) {
						eat.add(newS);
					}
					tfMap[nr][nc] = true;
					info.add(newS);
				}
				

			}
			////////////////////////////////////////////
			
			
			
			if (cnt == 0 && !eat.isEmpty()) {

				int len = eat.size(); 
				if (len >= 2) {
					eat.sort((Shark o1 , Shark o2) -> o1.r - o2.r);
					int maxR = eat.get(0).r;
					for (int i = len-1; i >= 0 ; i--) {
						if (eat.get(i).r != maxR) {
							eat.remove(i);
						}else {
							break;   //가장 위에 있는 물고기
						}
					}
				}
				len = eat.size(); 
				if (len >= 2) {
					eat.sort((Shark o1 , Shark o2) -> o1.c - o2.c); // 가장 왼쪽에 있는 물고기

				}
				//먹이 판단
				
				
				
				need --;			//level up
				if (need == 0) {
					level++;
					need = level;
				
				}
				
				res += eat.get(0).dist;
				shark = new Shark(eat.get(0).r, eat.get(0).c, 0);
				map[shark.r][shark.c] = 0;
				tfMap = new boolean[N][N];
				eat.clear();
				info.clear();
				info.add(shark);

			}
			
			
			
			if (cnt == 0) {        //한사이클 판단.
				cnt = info.size();
			}
		}
	}
	
	
}
