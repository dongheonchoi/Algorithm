
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class no{
	Long num;
	int cnt;
	public no(Long num , int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int res = -1;
		
		Queue<no> que = new LinkedList<no>();
		que.add(new no((long) A, 1));
		
		while (!que.isEmpty()) {
			no n = que.poll();
			Long doN = (long) (n.num*2);
			Long pN = (long) (n.num*10+1);

			if( doN == B || pN == B) {
				res = n.cnt+1;
				break;
			}else{
				if(doN < B) {
					que.add(new no(doN , n.cnt+1));
				}
				if(pN < B) {
					que.add(new no(pN , n.cnt+1));					
				}
				
			}

		}
		
		System.out.println(res);
		
		
	}

}
