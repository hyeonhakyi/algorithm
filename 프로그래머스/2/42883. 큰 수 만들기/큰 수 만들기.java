import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char now = number.charAt(i);

            // 수정: 제거할 수 있고, 앞 숫자가 현재 숫자보다 작으면 제거
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < now) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            // 수정: 현재 숫자를 뒤에 추가
            sb.append(now);
        }

        // 수정: 아직 제거해야 할 숫자가 남았다면 뒤에서 제거
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.toString();
    }//solution end
}//class end