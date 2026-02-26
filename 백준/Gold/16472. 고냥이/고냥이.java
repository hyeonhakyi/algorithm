import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] arr = new int[26];
        int distinct = 0;
        int answer = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            int rIdx= s.charAt(right) - 'a';
            if(arr[rIdx] == 0) distinct++;
            arr[rIdx]++;

            while(distinct > n){
                int lIdx = s.charAt(left) - 'a';
                arr[lIdx]--;
                if(arr[lIdx] == 0) distinct--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }//main end
}//class end
