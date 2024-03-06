import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static  String s ,t;
    static int len;
    static boolean end;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        len = t.length() - s.length();

        end = false;

        StringBuilder strb = new StringBuilder(s);
        strb.reverse();
        if(t.contains(s) || t.contains(strb)){
            dfs(s , 0 , true);
        }


        if(end){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    private static void dfs(String str, int cnt, boolean tf) {
        if(end){
            return;
        }
        if(str.equals(t)){
            end = true;
            return;
        }
        if(cnt > len){
            return;
        }

        StringBuilder sbb = new StringBuilder(str+"A");
        boolean tt = false;
        if(t.contains(str + "A")|| t.contains(sbb.reverse())){
            tt = true;
        }

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        boolean ff = t.contains(sb + "B");

        if(tf || tt){
            dfs(str + "A" ,cnt+1 , tt);
        }
        if(tf || ff){
            dfs(sb+ "B",cnt+1, ff);
        }


    }
}
