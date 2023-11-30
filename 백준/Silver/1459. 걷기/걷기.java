import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		long W = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		
		long tem = 0;
		
		tem = (X+Y)*W;
		
		long tem2 =0;
		if ((X+Y)%2 == 1) {
			tem2 = Math.min((Math.max(X, Y)-1)*S + W ,(Math.min(X, Y))*S+(Math.abs(X-Y))*W);
		}else {
			tem2 = Math.min(Math.max(X, Y)*S,(Math.min(X, Y))*S+(Math.abs(X-Y))*W);
		}	
		System.out.println(Math.min(tem , tem2));
	}
}
