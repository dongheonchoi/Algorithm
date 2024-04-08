import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] sequence;
    static int length;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sequence = new int[len];
        sequence[0] = arr[0];
        length = 0;
        for(int i = 1; i < len; i++){
            int tem = arr[i];
            if(tem > sequence[length]){
                sequence[++length] = tem;
            }else if(tem < sequence[length]){
                sequence[binarySearch(tem ,length)] = tem;
            }else {
                continue;
            }
        }
        System.out.println(length+1);
    }
    public static int binarySearch(int num ,int length){

        int lo = 0;
        int hi = length;

        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(sequence[mid] < num){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
//        System.out.println("num : " + num + " length : " + length + " lo : " + lo);
        return lo;
    }
}
