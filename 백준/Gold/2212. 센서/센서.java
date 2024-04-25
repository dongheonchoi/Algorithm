import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class pair implements Comparable<pair>{
        int idx;
        int value;
        public pair(int idx , int value){
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(pair o) {
            return o.value - this.value;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int K = Integer.parseInt(br.readLine());
        if(K >= N ){
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            arrList.add(Integer.parseInt(st.nextToken()));
        }

        arrList.sort((o1,o2) -> o1 - o2);
        int a = arrList.get(0);

        PriorityQueue<pair> pque = new PriorityQueue<>();
        for(int i = 1; i < N; i++){
            int b = arrList.get(i);
            pque.add(new pair(i , b-a));
            a = b;
        }
        ArrayList<pair> aList = new ArrayList<>();
        aList.add(new pair(0 , 0));
        for(int i = 1; i < K; i++){
            aList.add(pque.poll());
        }

        aList.sort((o1 , o2) -> o1.idx - o2.idx);

        int res = 0;
        for(int i = 0; i < K; i++){
            if(i == K-1){
                res += arrList.get(N-1) - arrList.get(aList.get(i).idx);
            }else{
                res += arrList.get(aList.get(i+1).idx-1) - arrList.get(aList.get(i).idx);
            }

        }
        System.out.println(res);
    }
}
