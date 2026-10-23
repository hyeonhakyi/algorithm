import java.util.*;

class Solution {

    public int[][] solution(int n, int[][] build_frame) {

        boolean[][][] arr = new boolean[n + 1][n + 1][2];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            // 설치 = true, 삭제 = false
            arr[x][y][a] = (b == 1);

            // 규칙을 위반하면 명령 취소
            if (!isValid(arr, n)) {
                arr[x][y][a] = (b == 0);
            }
        }

        List<int[]> list = new ArrayList<>();

        // x → y → a 순서로 정렬된 결과
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                for (int a = 0; a < 2; a++) {

                    if (arr[x][y][a]) {
                        list.add(new int[]{x, y, a});
                    }
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    // 모든 구조물이 규칙을 만족하는지 확인
    private static boolean isValid(boolean[][][] arr, int n) {

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {

                // 기둥 검사
                if (arr[x][y][0]) {

                    boolean valid =
                        y == 0 ||
                        (y > 0 && arr[x][y - 1][0]) ||
                        arr[x][y][1] ||
                        (x > 0 && arr[x - 1][y][1]);

                    if (!valid) return false;
                }

                // 보 검사
                if (arr[x][y][1]) {

                    boolean valid =
                        (y > 0 && arr[x][y - 1][0]) ||
                        (y > 0 && x < n && arr[x + 1][y - 1][0]) ||
                        (x > 0 && x < n &&
                         arr[x - 1][y][1] && arr[x + 1][y][1]);

                    if (!valid) return false;
                }
            }
        }

        return true;
    }
}