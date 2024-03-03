import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < testCase; t++) {
			String p = br.readLine();
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine() ,"[], ");
			
			String[] arr = new String[len];
			
			for(int i = 0; i < len; i++) {
				arr[i] = st.nextToken();
			}
 			
			boolean tf = true;
			
			int left = 0;
			int right = 0;
			
			for(int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'R') {
					tf = !tf;
				}else{
					if (tf) {
						left++;
					}else {
						right++;
					}
				}
			}
			
			if(len < left+right) {
				sb.append("error");
				sb.append("\n");
				continue;
			}else if (len == left + right) {
				sb.append("[]");
				sb.append("\n");
				continue;
			}

			if(tf) {
				sb.append("[");
				for(int i = left; i < len-right; i++) {
					sb.append(arr[i]+",");
				}
				sb.replace(sb.length()-1, sb.length(), "]");
				sb.append("\n");
			}else {
				
				sb.append("[");
				for(int i = len-right-1; i >= left; i--) {
					sb.append(arr[i]+",");
				}
				sb.replace(sb.length()-1, sb.length(), "]");
				sb.append("\n");

			}
		}
		System.out.println(sb);
		
	}

}
