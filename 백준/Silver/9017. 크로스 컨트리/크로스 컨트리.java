import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T --> 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            Map<Integer,Integer> map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                map.put(num,map.getOrDefault(num,0) + 1);
            }

            Map<Integer, List<Integer>> total = new HashMap<>();

            int score = 1;
            for(int i = 0; i < n; i++){
                int team = arr[i];

                if(map.get(team) < 6) continue;

                total.putIfAbsent(team, new ArrayList<>());
                total.get(team).add(score++);
            }

            int winner = -1;
            int minSum = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;

            for(int team : total.keySet()){
                List<Integer> scores = total.get(team);

                int sum = 0;
                for(int i = 0; i < 4; i++){
                    sum += scores.get(i);
                }

                int fifth = scores.get(4);

                if(sum < minSum || (sum == minSum && fifth < minFifth)){
                    minSum = sum;
                    minFifth = fifth;
                    winner = team;
                }
            }

            sb.append(winner).append("\n");
        }//testCase end

        System.out.println(sb.toString());
    }//main end
}//class end
