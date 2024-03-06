import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(tmp == 0){
                union(x,y);
            }else{
                if(findSet(x) == findSet(y)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }



    }

    public static int findSet(int x){
        if(arr[x] == x){
            return x;
        }
        return arr[x] = findSet(arr[x]);
    }

    public static void union(int x,int y){
        int x_arr = findSet(x);
        int y_arr = findSet(y);

        if(x_arr > y_arr){
            arr[x_arr] = y_arr;
        }else{
            arr[y_arr] = x_arr;
        }
    }

}
