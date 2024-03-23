import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dice;
	static int[] dR = { 0, 0, 0, -1, 1 };
	static int[] dC = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] order = new int[K];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}

		dice = new int[4][3];
		for (int i = 0; i < K; i++) {
			int tem = order[i];
			int nr = X + dR[tem];
			int nc = Y + dC[tem];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				X = nr;
				Y = nc;
				roll(tem);
				if (map[X][Y] == 0) {
					map[X][Y] = dice[3][1];
				} else {
					dice[3][1] = map[X][Y];
					map[X][Y] = 0;
				}
				sb.append(dice[1][1]).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static void roll(int dir) {
		if (dir == 1) {
			int bottom = dice[1][2];
			int temNum = dice[3][1];
			for (int i = 1; i >= 0; i--) {
				dice[1][i + 1] = dice[1][i];
			}
			dice[3][1] = bottom;
			dice[1][0] = temNum;
		} else if (dir == 2) {
			int bottom = dice[1][0];
			int temNum = dice[3][1];
			for (int i = 1; i < 3; i++) {
				dice[1][i - 1] = dice[1][i];
			}
			dice[3][1] = bottom;
			dice[1][2] = temNum;
		} else if (dir == 3) {
			int bottom = dice[0][1];
			for (int i = 1; i < 4; i++) {
				dice[i - 1][1] = dice[i][1];
			}
			dice[3][1] = bottom;
		} else {
			int bottom = dice[3][1];
			for (int i = 2; i >= 0; i--) {
				dice[i + 1][1] = dice[i][1];
			}
			dice[0][1] = bottom;
		}

	}

}
