import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                // 수정: 짝수면 순간이동으로 온 것이므로 배터리 소모 없이 절반으로 이동
                n /= 2;
            } else {
                // 수정: 홀수면 점프가 필요하므로 배터리 1 사용
                n -= 1;
                answer++;
            }
        }

        return answer;
    }//solution end
}//class end