import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        int left = 1;        // 세로 후보
        int right = total;   // 가로 후보

        while (left <= right) {
            long area = (long) left * right; // 수정 1: int 오버플로우 방지

            if (area == total) {
                // 수정 2: 전체 넓이뿐만 아니라 내부 노란색 영역도 확인해야 함
                if ((right - 2) * (left - 2) == yellow) {
                    answer[0] = right; // 가로
                    answer[1] = left;  // 세로
                    break;             // 수정 3: 정답을 찾았으므로 종료
                }

                // 전체 넓이는 맞지만 노란색 조건이 안 맞으면 다음 후보로 이동
                right--;
                left++;
            } else if (area > total) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }//solution end
}//class end