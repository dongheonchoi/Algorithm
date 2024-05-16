import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder()); //3 2 1
        PriorityQueue<Integer> b = new PriorityQueue<>();                           //4 5 6

        for (int i = 0 ; i < 2; i++){
            int tem = Integer.parseInt(br.readLine());
            if (a.isEmpty()){
                a.offer(tem);
                sb.append(tem + "\n");
            } else if (b.isEmpty()) {
                a.offer(tem);
                tem = a.poll();
                b.offer(tem);
                sb.append(a.peek() + "\n");
            }
        }

        for (int i = 0; i < n-2; i++){
            int tem = Integer.parseInt(br.readLine());
            Integer low = a.peek();
            Integer high = b.peek();

            if (low > tem){
                if (a.size() > b.size()){
                    b.offer(a.poll());
                    a.offer(tem);
                    sb.append(a.peek() + "\n");
                }else {
                    a.offer(tem);
                    sb.append(low + "\n");
                }
            } else if (high < tem) {
                if (a.size() > b.size()){
                    b.offer(tem);
                    sb.append(low + "\n");
                }else {
                    b.offer(tem);
                    a.offer(b.poll());
                    sb.append(a.peek() + "\n");
                }
            }else {
                if (a.size() > b.size()){
                    b.offer(tem);
                    sb.append(low + "\n");
                }else {
                    a.offer(tem);
                    sb.append(tem + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
