import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        int x = 0;
        int y = 0;

        Set<String> visited = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);

            int nx = x;
            int ny = y;

            if (c == 'U') {
                ny++;
            } else if (c == 'D') {
                ny--;
            } else if (c == 'L') {
                nx--;
            } else if (c == 'R') {
                nx++;
            }

            if (!check(nx, ny)) {
                continue;
            }

            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            if (!visited.contains(path1)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }//solution end

    private static boolean check(int x, int y) {
        return x >= -5 && x <= 5 && y >= -5 && y <= 5;
    }//check end
}//class end