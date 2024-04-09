import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int lo = 1;
        int hi = K;

        while (lo < hi){
            int mid = (lo+hi)/2;

            int sum = 0;

            for(int i = 1; i <= N; i++){
                sum += Math.min(mid/i , N);
            }

            if(K <= sum) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }


}
