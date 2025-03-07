import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> collatz = new ArrayList<>();
        collatz.add(k);
        
        // 1. 우박수열 생성
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            collatz.add(k);
        }
        
        int n = collatz.size() - 1; // 우박수열이 끝날 때까지의 x 좌표 크기
        
        // 2. 각 구간의 정적분(사다리꼴 넓이) 계산
        double[] areas = new double[n]; // (x, y)에서 (x+1, y')까지의 넓이
        for (int i = 0; i < n; i++) {
            areas[i] = (collatz.get(i) + collatz.get(i + 1)) / 2.0;
        }
        
        // 3. 누적 합을 이용한 정적분 결과 계산
        double[] prefixSum = new double[n + 1]; // 넓이의 누적 합
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + areas[i - 1];
        }
        
        // 4. 각 범위별 정적분 결과 계산
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];

            int end = n + b; // b가 음수일 경우 실제 끝 위치
            if (a > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefixSum[end] - prefixSum[a];
            }
        }
        
        return answer;
    }
}
