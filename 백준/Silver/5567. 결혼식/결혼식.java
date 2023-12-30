import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] tf = new boolean[ N+1];
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N ; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arrList.get(a).add(b);
			arrList.get(b).add(a);
		}
		
		int cnt = 0;
		tf[1] = true;
		ArrayList<Integer> sang = arrList.get(1);
		for (int i = 0; i < sang.size(); i++) {
			int nn = sang.get(i);
			if (!tf[nn]) {
				cnt++;
			}
			tf[nn] = true;
			ArrayList<Integer> friend = arrList.get(nn);
			for (int j = 0; j < friend.size(); j++) {
				int nnn = friend.get(j);
				if (!tf[nnn]) {
					cnt++;
					tf[nnn] = true;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
