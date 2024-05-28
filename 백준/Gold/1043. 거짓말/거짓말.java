import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static ArrayList<Integer>[] parties,partiesIn;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        parties = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            parties[i] = new ArrayList<>();
        }

        partiesIn = new ArrayList[m];
        for(int i = 0; i < m; i++){
            partiesIn[i] = new ArrayList<>();
        }

        visited = new boolean[m];

        st = new StringTokenizer(br.readLine());
        int knownPeople = Integer.parseInt(st.nextToken());
        arr = new int[knownPeople];

        for(int i = 0; i < knownPeople; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int party = 0; party < m; party++){
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());

            for(int j = 0; j < people; j++){
                int person = Integer.parseInt(st.nextToken());

                parties[person].add(party);
                partiesIn[party].add(person);
            }
        }

        for(int i = 0; i < knownPeople; i++){
            dfs(arr[i]);
        }

        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                ++answer;
            }
        }
        System.out.println(answer);
    }//main end

    private static void dfs(int person){
        for(int i = 0; i < parties[person].size(); i++){
            int party = parties[person].get(i);

            if(!visited[party]){
                visited[party] = true;

                for(int j = 0; j < partiesIn[party].size(); j++){
                    int nextPerson = partiesIn[party].get(j);
                    dfs(nextPerson);
                }
            }
        }
    }//dfs end
}//class end
