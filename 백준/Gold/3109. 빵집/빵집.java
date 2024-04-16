import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c , res;
    static boolean flag;
    static char[][] map;
    static boolean[][] tf;
    static int[] dirR = {-1 , 0 , 1};
//    static int[] dirC = {1 , 1 , 1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            for (int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
            }
        }

        tf = new boolean[r][c];
        res = 0;
        for (int i = 0; i < r; i++){
            flag = false;
            if(map[i][0] != 'x'){
                fn(i , 0);
            }
        }

        System.out.println(res);

    }

    private static void fn(int row, int col) {

        if(col == c-1){
            res++;
            flag = true;
            return;
        }

        for(int i = 0; i < 3; i++){
            if(flag){
                return;
            }
            int nR = row + dirR[i];
            int nC = col + 1;
            if(nR >= 0 && nR < r && nC >= 0 && nC < c && map[nR][nC] != 'x' && !tf[nR][nC] ){
                tf[nR][nC] = true;
                fn(nR , nC);
            }
        }



    }
}
