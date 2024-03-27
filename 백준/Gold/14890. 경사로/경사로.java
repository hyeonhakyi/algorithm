import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int[][] row;
    private static int[][] col;
    private static int n,l;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        row = new int[n][n];
        col = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                col[i][j] = Integer.parseInt(st.nextToken());
                row[j][i] = col[i][j];
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(dfs(col,i)){
                count++;
            }
            if(dfs(row,i)){
                count++;
            }
        }
        System.out.println(count);
    }//main end

    private static boolean dfs(int[][] arr,int idx){
        int cnt = 1;
        int height = arr[idx][0];

        for(int i = 1; i < n; i++){
            if(height == arr[idx][i]){
                cnt++;
            }else if(arr[idx][i] - height == 1){ // 오르막길
                if(cnt < l){
                    return false;
                }
                cnt = 1;
                height = arr[idx][i];
            }else if(height - arr[idx][i] == 1){//내리막길
                if(n < i+l){
                    return false;
                }
                for(int j = 1; j < l; j++){
                    if(height - arr[idx][++i] != 1){
                        return false;
                    }
                }
                cnt = 0;
                height = arr[idx][i];
            }else{
                return false;
            }
        }
        return true;
    }//dfs end
}//class end
