import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int r,c;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int l = 0;
        int e = r - 1;
        int answer = 0;

        while(l <= e){
            int mid = (l + e) / 2;

            if(check(mid)){
                answer = mid;
                l = mid + 1;
            }else{
                e = mid - 1;
            }

        }

        System.out.println(answer);;
    }//main end

    private static boolean check(int cut){
        HashSet<String> set = new HashSet<>();

        int len = r - cut;
        for(int col = 0; col < c; col++){
            StringBuilder sb = new StringBuilder(len);
            for(int row = cut; row < r; row++){
                sb.append(arr[row][col]);
            }
            String key = sb.toString();
            if(!set.add(key)) return false;
        }
        return true;
    }//check end
}//class end
