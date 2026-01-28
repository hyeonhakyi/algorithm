import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int answer = 0;
        parent = new int[g+1];

        for(int i = 1; i <= g; i++){
            parent[i] = i;
        }

        for(int i = 0; i < p; i++){
            int n = Integer.parseInt(br.readLine());

            int available = find(n);

            if(available == 0){
                break;
            }

            answer++;
            
            union(available,available-1);
        }

        System.out.println(answer);
    }//main end

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }//find and

    private static void union(int a,int b){
        a = find(a);
        b = find(b);

        parent[a] = b;
    }//union end
}//class end
