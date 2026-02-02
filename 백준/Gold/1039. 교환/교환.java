import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int m = n.length();

        Queue<String> q = new LinkedList<>();
        q.offer(n);

        for(int depth = 0; depth < k; depth++){
            Set<String> visited = new HashSet<>();
            int size = q.size();

            while(size --> 0){
                String now = q.poll();
                char[] arr = now.toCharArray();

                for(int i = 0; i < m; i++){
                    for(int j = i + 1; j < m; j++){
                        swap(arr,i,j);

                        if(arr[0] != '0'){
                            String next = new String(arr);
                            if(!visited.contains(next)){
                                visited.add(next);
                                q.offer(next);
                            }
                        }

                        swap(arr,i,j);
                    }
                }
            }

            if(q.isEmpty()){
                System.out.println(-1);
                return;
            }
        }

        int answer = 0;
        for(String s : q){
            answer =  Math.max(answer,Integer.parseInt(s));
        }
        System.out.println(answer);
    }//main end


    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }//swap end
}//class end
