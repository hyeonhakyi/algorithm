import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] arr;
    private static int[] answer;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        per(0);
    }//main end

    private static void per(int count){
        if(count == m){
            for(int i = 0; i < m; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        int temp = -1;
        for(int i = 0; i < arr.length; i++){
            if(visited[i]){
                continue;
            }
            if(temp != arr[i]){
                visited[i] = true;
                answer[count] = arr[i];
                temp = arr[i];
                per(count+1);
                visited[i] = false;
            }
        }
    }//per end
}//class end
