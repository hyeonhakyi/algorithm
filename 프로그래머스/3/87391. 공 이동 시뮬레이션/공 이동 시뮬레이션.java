class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long sx = x, ex = x;
        long sy = y, ey = y;

        // 쿼리들을 역순으로 진행
        for(int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            int dx = queries[i][1];

            if(dir == 0) { // 왼쪽(열 감소) 쿼리의 역방향은 오른쪽(열 증가)
                if(sy != 0) sy += dx;
                ey = Math.min(ey + dx, m - 1);
            }
            else if(dir == 1) { // 오른쪽(열 증가) 쿼리의 역방향은 왼쪽(열 감소)
                if(ey != m - 1) ey -= dx;
                sy = Math.max(sy - dx, 0);
            }
            else if(dir == 2) { // 위(행 감소) 쿼리의 역방향은 아래(행 증가)
                if(sx != 0) sx += dx;
                ex = Math.min(ex + dx, n - 1);
            }
            else { // 아래(행 증가) 쿼리의 역방향은 위(행 감소)
                if(ex != n - 1) ex -= dx;
                sx = Math.max(sx - dx, 0);
            }

            // 불가능한 범위 체크 (아예 범위가 격자 밖이면 0)
            if(sx > ex || sy > ey) return 0;
        }

        // 마지막에 sx~ex, sy~ey 범위 안의 모든 칸이 정답
        return (ex - sx + 1) * (ey - sy + 1);
    }
}
