import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int X = Integer.parseInt(st.nextToken());
        Long Y = Long.parseLong(st.nextToken());

        int Z = (int)(Y*100/X);

        if(Z == 99 || Z == 100){
            System.out.println(-1);
            return;
        }

        int lo = 1;
        int hi = X;
        while (lo < hi){
            int mid = (hi + lo)/ 2;

            if( (Y+mid)*100/(X+mid) > Z){
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);

    }
}
