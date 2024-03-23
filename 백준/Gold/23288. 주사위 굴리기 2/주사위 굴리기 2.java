import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, moveDir, cntScore, r, c, scoreR, scoreC;
	static int map[][];
	static boolean checkMap[][];
	static int floorNum;
	static int dice[][] = { { 0, 2, 0, 0 }, { 4, 1, 3, 6 }, { 0, 5, 0, 0 }, { 0, 6, 0, 0 } };
	static int bottomNum;
	static int tmpDice;
	static int dirR[] = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int dirC[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		r = 0;
		c = 0;
		moveDir = 1;
		
		int score = 0;
		for (int i = 0; i < k; i++) {
			move();
			cntScore = 0;
			floorNum = map[r][c];
			checkMap = new boolean[n][m];
			score(r, c);
			//System.out.println(r + " " + c);
			//System.out.println("floornum =>" + floorNum);
			score = score + cntScore * floorNum;
			//System.out.println(score);
		}


		System.out.println(score);

	}

	static void move() {
		int nextR = r + dirR[moveDir];
		int nextC = c + dirC[moveDir];

		if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) {
			moveDir = (moveDir + 2) % 4;
			nextR = r + dirR[moveDir];
			nextC = c + dirC[moveDir];
		}

		r = nextR;
		c = nextC;

		if (moveDir == 0) {
			tmpDice = dice[0][1];
			for (int i = 0; i < 3; i++) {
				dice[i][1] = dice[i + 1][1];
			}
			dice[3][1] = tmpDice;
			dice[1][3] = tmpDice;
		} else if (moveDir == 1) {
			tmpDice = dice[1][3];
			for (int i = 3; i > 0; i--) {
				dice[1][i] = dice[1][i - 1];
			}
			dice[1][0] = tmpDice;
			dice[3][1] = dice[1][3];
		} else if (moveDir == 2) {
			tmpDice = dice[3][1];
			for (int i = 3; i > 0; i--) {
				dice[i][1] = dice[i - 1][1];
			}
			dice[0][1] = tmpDice;
			dice[1][3] = dice[3][1];
			
		} else if (moveDir == 3) {
			tmpDice = dice[1][0];
			for (int i = 0; i < 3; i++) {
				dice[1][i] = dice[1][i+1];
			}
			dice[1][3] = tmpDice;
			dice[3][1] = tmpDice;
		}

		int A = dice[1][3];
		int B = map[r][c];
		if (A > B) {
			moveDir = (moveDir + 1) % 4;
		}else if (A < B) {
			moveDir = (moveDir-1);
			if (moveDir < 0) {
				moveDir = 3;
			}
		}
	}

	static void score(int rPoint, int cPoint) {
		cntScore++;
		checkMap[rPoint][cPoint] = true;
		for (int i = 0; i < 4; i++) {
			scoreR = rPoint + dirR[i];
			scoreC = cPoint + dirC[i];
			if (rangeScore() && !checkMap[scoreR][scoreC] && map[rPoint][cPoint] == map[scoreR][scoreC]) {
				score(scoreR, scoreC);
			}
		}

	}

	static boolean rangeScore() {
		return (scoreR >= 0 && scoreC >= 0 && scoreR < n && scoreC < m);
	}

}