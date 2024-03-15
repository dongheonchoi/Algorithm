import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N , K , res , startP;
    static boolean[] multi , tf;
    static HashMap<Integer , Queue<Integer>> hashMap;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        res = 0;

        hashMap = new HashMap<>();

        for(int i  = 1; i < 101; i++){
            hashMap.put(i , new LinkedList<>());
        }

        multi = new boolean[101];   // 멀티탭에 꽂혀 있는 콘센트

        tf = new boolean[101];      // 존재하는 전기기구 인지 확인

        arr = new int[K+1];         // 진행 순서에 따른 전기기구

        st = new StringTokenizer(br.readLine() , " ");
        int idx = 0;
        int cnt = 0;
        for (int i = 1; i < K+1; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            tf[a] =true;
            if(idx < N){  //입력을 받으면서 N개의 멀티탭에 모두 꽂기위해 사용
                if(!multi[a]){
                    idx++;
                    multi[a] = true;
                }
            }else{
                if(idx == N){
                    idx++;
                    startP = i;
                }
                cnt++;
                hashMap.get(a).add(i);
            }
        }

        //cnt 횟수만큼만 fn을 진행하면 된다.
        for(int i = 0; i < cnt; i++){
            fn(startP++);
        }

        System.out.println(res);

    }

    private static void fn(int idx) {
        hashMap.get(arr[idx]).poll();
        if(multi[arr[idx]]){
            return;
        }
        res ++;
        int temN = 0;
        int temP = 0;
        for(int i = 1; i < 101; i++){ // 이 i는 숫자
            if(tf[i] && multi[i]){
                Queue<Integer> temQ = hashMap.get(i);
                if(temQ.size() != 0){
                    if(temP < temQ.peek()){
                        temP = temQ.peek();
                        temN = i;
                    }
                }else{
                    multi[i] = false;
                    multi[arr[idx]] =true;
                    return;
                }
            }
        }
        multi[temN] = false;
        multi[arr[idx]] =true;
        return;

    }
}
