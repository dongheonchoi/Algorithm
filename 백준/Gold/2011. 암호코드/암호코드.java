
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		if(str.charAt(0) == 48) {
			System.out.println(0);
			return;
		}
		
		int tem = -1;
		
		int res = 1;
		int temSum = 0;
		int idx =str.length()-1;
		
		while(idx != -1){
			int b = str.charAt(idx--)-48;
//			System.out.println(b);
			if(tem == 0) {
				if(b == 1 || b == 2) {
				tem = 10;
				temSum = 0;
				continue;
				}else {
					res = 0;
					break;
				}
			}
			if(b == 1) {
				int t = res;
				res = (res + temSum)%1000000;
				temSum = t;
			}else if(b == 2) {
				if(tem>=0 && tem<=6){
					int t = res;
					res = (res + temSum)%1000000;
					temSum = t;
				}else {
					temSum = res;
				}
			}else {
				if(b != 0) {
					temSum = res;
				}else {
//					tem = 0;
					temSum = 0;
//					continue;
				}
			}
			tem = b;
//			System.out.println("임시 결과 : " + res);
		}
		System.out.println(res);
	}


}
