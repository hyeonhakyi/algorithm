import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N;i++) {
                list.add(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M;i++) {
                String cmd = st.nextToken();
                if(cmd.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j<y;j++) {
                        list.add(x++,st.nextToken());
                    }
                } else if(cmd.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j<y;j++) {
                        list.remove(x);
                    }
                } else {
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j<y;j++) {
                        list.add(st.nextToken());
                    }
                }
            }

            bw.append("#"+tc+" ");
            for(int i = 0; i<10;i++) {
                bw.append(list.get(i)+" ");
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}