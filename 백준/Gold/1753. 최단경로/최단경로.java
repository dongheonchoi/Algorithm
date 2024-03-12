import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node>{
    int end;
    int cost;
    public node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(node o){return this.cost - o.cost;}

}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(br.readLine());

        int[] res = new int[V+1];
        boolean[] tf = new boolean[V+1];

        Arrays.fill(res, Integer.MAX_VALUE);
        res[startPoint] = 0;
        tf[startPoint] = true;

        ArrayList<ArrayList<node>> arrayList = new ArrayList<>();

        for (int i = 0; i < V+1; i++){
            arrayList.add(new ArrayList<node>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine() , " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(new node(b ,c));

        }

        PriorityQueue<node> pq = new PriorityQueue<>();

        for (int i = 0; i < arrayList.get(startPoint).size(); i++){
            node nn = arrayList.get(startPoint).get(i);
            pq.add(new node(nn.end , nn.cost));
        }

        while (!pq.isEmpty()){
            node nn = pq.poll();

            if (!tf[nn.end]) {
                res[nn.end] = nn.cost;
                tf[nn.end] = true;
                for (int i = 0; i < arrayList.get(nn.end).size(); i++) {
                    node tem = arrayList.get(nn.end).get(i);
                    if (!tf[tem.end]) {
                        pq.add(new node(tem.end, res[nn.end] + tem.cost));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < V+1; i++) {
            if (tf[i]) {
                sb.append(res[i]).append("\n");
            }else{
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb);
    }
}
