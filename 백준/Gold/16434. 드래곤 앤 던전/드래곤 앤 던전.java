import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long firstAtack;
    static int[] t;
    static long[] a,h;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        firstAtack = Integer.parseInt(st.nextToken());

        t = new int[n];
        a = new long[n];
        h = new long[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            a[i] = Long.parseLong(st.nextToken());
            h[i] = Long.parseLong(st.nextToken());
        }

        long left = 1;
        long right = Long.MAX_VALUE / 4;
        answer = right;

        while(left <= right){
            long mid = (right + left) / 2;

            if(canCover(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }//main end

    private static boolean canCover(long maxHp){
        long curHp = maxHp;
        long atk = firstAtack;

        for(int i = 0; i < n; i++){
            if(t[i] == 1){
                long monsterAtk = a[i];
                long monsterHp = h[i];

                long heroAttackCount = (monsterHp + atk - 1) / atk;

                long monsterAttackCount = heroAttackCount - 1;

                long damage = monsterAttackCount * monsterAtk;
                curHp -= damage;

                if(curHp <= 0){
                    return false;
                }
            }else{
                atk += a[i];
                curHp = Math.min(maxHp,curHp + h[i]);
            }
        }
        return true;
    }//canCover end
}//class end
