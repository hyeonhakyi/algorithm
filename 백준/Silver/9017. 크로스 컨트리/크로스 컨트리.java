
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int[] answer = new int[test];

        for(int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] rank = new int[n];
            HashMap<Integer, Integer> cntMap = new HashMap<>();
            int teamNum = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());

                cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
                rank[i] = x;
                teamNum = Math.max(teamNum, x);
            }

            int[] five = new int[teamNum + 1];
            HashMap<Integer, Integer> scoreMap = new HashMap<>();
            HashMap<Integer, Integer> tmpMap = new HashMap<>();
            int score = 1;

            for(int r : rank) {
                if (cntMap.get(r) == 6) {
                    tmpMap.put(r, tmpMap.getOrDefault(r, 0) + 1);

                    if(tmpMap.get(r) <= 4) {
                        scoreMap.put(r, scoreMap.getOrDefault(r, 0) + score);
                    }

                    if(tmpMap.get(r) == 5) {
                        five[r] = score;
                    }

                    score++;
                }
            }

            int result = Integer.MAX_VALUE;
            int fiveScore = Integer.MAX_VALUE;

            for(Integer key : scoreMap.keySet()) {
                int tmp = scoreMap.get(key);

                if (tmp < result) {
                    result = tmp;
                    fiveScore = five[key];
                    answer[t] = key;
                } else if (tmp == result) {
                    if (fiveScore > five[key]) {
                        answer[t] = key;
                    }
                }
            }
        }//testCase end
        for(int i = 0; i < test; i++) {
            System.out.println(answer[i]);
        }
    }//main end
}//class end
