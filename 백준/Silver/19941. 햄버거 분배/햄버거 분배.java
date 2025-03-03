import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();


        List<Integer> bList = new ArrayList<>();
        List<Integer> pList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'P'){
                pList.add(i);
            }else if(str.charAt(i) == 'H'){
                bList.add(i);
            }
        }

        int pIdx = 0; int bIdx = 0; int count = 0;
        while(pIdx < pList.size() && bIdx < bList.size()) {
            int people = pList.get(pIdx);
            int berger = bList.get(bIdx);

            if (Math.abs(people - berger) <= k) {
                count++;
                pIdx++;
                bIdx++;
            }else if(people > berger){
                bIdx++;
            }else{
                pIdx++;
            }
        }
        System.out.println(count);
    }//main en
}//class end
