import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        // factorial[i] = i!
        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // 아직 선택하지 않은 숫자
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // 1부터 시작하는 순서를 0부터 시작하도록 변경
        k--;

        for (int position = 0; position < n; position++) {
            // 현재 숫자를 하나 선택한 후 만들 수 있는 순열 개수
            long blockSize = factorial[n - 1 - position];

            // 몇 번째 숫자를 선택할지 계산
            int index = (int) (k / blockSize);

            answer[position] = numbers.remove(index);

            // 선택한 묶음 내부에서의 순서
            k %= blockSize;
        }

        return answer;
    }//solution end
}//class end