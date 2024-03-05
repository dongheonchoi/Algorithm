import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class room implements Comparable<room>{
    int start;
    int end;
    public room(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(room o) {
        return this.start - o.start;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<room> pq = new PriorityQueue<>();

        for (int i = 0; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new room(a , b));
        }

        PriorityQueue<Integer> endPoint = new PriorityQueue<>();

        endPoint.add(pq.poll().end);

        while(!pq.isEmpty()){
            room tem = pq.poll();
            if(endPoint.peek() <= tem.start){
                endPoint.poll();
            }
            endPoint.add(tem.end);
        }
        System.out.println(endPoint.size());
    }
}
