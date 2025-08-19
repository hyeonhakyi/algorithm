import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        // 왼쪽 최소값
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
            leftMin[i] = min;
        }

        // 오른쪽 최소값
        min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, a[i]);
            rightMin[i] = min;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            // 자신이 왼쪽 최소 or 오른쪽 최소면 생존 가능
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}
