import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // 수정: right - left + 1개를 담아야 함
        int[] answer = new int[(int)(right - left + 1)];

        int idx = 0;

        // 수정: 전체 배열을 만들지 않고 left부터 right까지만 계산
        for (long i = left; i <= right; i++) {
            long row = i / n; // 수정: 1차원 인덱스를 행 번호로 변환
            long col = i % n; // 수정: 1차원 인덱스를 열 번호로 변환

            // 수정: 해당 칸의 값은 max(row, col) + 1
            answer[idx++] = (int)(Math.max(row, col) + 1);
        }

        return answer;
    }//solution end
}//class end