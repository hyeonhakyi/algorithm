import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (true) {
            int chosenValue = -1;
            int nextI = -1;
            int nextJ = -1;

            for(int v = 100; v >= 0; v--) {
                int postA = findValue(a,i,v);
                if(postA == -1) continue;

                int postB = findValue(b,j,v);
                if(postB == -1) continue;

                chosenValue = v;
                nextI = postA;
                nextJ = postB;
                break;
            }

            if(chosenValue == -1) break;
            result.add(chosenValue);
            i = nextI + 1;
            j = nextJ + 1;
        }

        System.out.println(result.size());
        StringBuilder sb = new StringBuilder();

        if(!result.isEmpty()) {
            for(int num : result){
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb.toString());
    }//main end

    private static int findValue(int[] arr, int start, int target) {
        for(int i = start; i < arr.length; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }//findValue end
}//class end