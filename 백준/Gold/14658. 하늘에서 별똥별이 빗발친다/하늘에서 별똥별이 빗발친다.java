import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] xs,ys;
    static int n,m,l,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        xs = new int[k];
        ys = new int[k];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());

            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i = 0; i < k; i++){
            int baseX = xs[i];
            for(int j = 0; j < k; j++){
                int baseY = ys[j];

                int count = 0;
                for(int z = 0; z < k; z++){
                    if(check(baseX,baseY,xs[z],ys[z])){
                        count++;
                    }
                }

                if(count > max){
                    max = count;
                }
            }
        }
        System.out.println(k - max);
    }//main end

    private static boolean check(int bx,int by,int x,int y){
        return (bx <= x && x <= bx + l) && (by <= y && y <= by + l);
    }//check end
}//class end
