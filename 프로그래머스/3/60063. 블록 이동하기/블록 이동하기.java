import java.util.*;

class Node{
    int x1;
    int y1;
    int x2;
    int y2;
    int cnt;
    public Node(int x1,int y1,int x2,int y2,int cnt){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.cnt = cnt;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer,n;
    static int[][] board;
    public int solution(int[][] board) {
        answer = 0;
        this.board = board;
        n = board.length;
        
        return bfs();
    }//solution end
    
    private static int bfs(){
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Node start = new Node(0, 0, 0, 1, 0);
        q.offer(start);
        visited.add(makeKey(start));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if((now.x1 == n - 1 && now.y1 == n - 1) || (now.x2 == n - 1 && now.y2 == n - 1)){
                return now.cnt;
            }
            
            for(int d = 0; d < 4; d++){
                int nx1 = now.x1 + dx[d];
                int ny1 = now.y1 + dy[d];
                int nx2 = now.x2 + dx[d];
                int ny2 = now.y2 + dy[d];
                
                if (!check(nx1, ny1) || !check(nx2, ny2)) continue;

                Node next = new Node(nx1,ny1,nx2,ny2,now.cnt + 1);
                String key = makeKey(next);
                
                if(!visited.contains(key)){
                    visited.add(key);
                    q.offer(next);
                }
            }
            
            List<Node> rotated = getRotations(now);
            
            for(Node next : rotated){
                String key = makeKey(next);
                
                if(!visited.contains(key)){
                    visited.add(key);
                    q.offer(next);
                }
            }
        }
        
        return 0;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0;
    }//check end
    
    private static List<Node> getRotations(Node now) {
        List<Node> result = new ArrayList<>();

        int x1 = now.x1;
        int y1 = now.y1;
        int x2 = now.x2;
        int y2 = now.y2;
        int cnt = now.cnt;

        // 가로 상태
        if (x1 == x2) {
            // 위, 아래로 회전
            for (int dir : new int[]{-1, 1}) {
                if (check(x1 + dir, y1) && check(x2 + dir, y2)) {
                    result.add(new Node(x1, y1, x1 + dir, y1, cnt + 1));
                    result.add(new Node(x2, y2, x2 + dir, y2, cnt + 1));
                }
            }
        }
        // 세로 상태
        else if (y1 == y2) {
            // 왼쪽, 오른쪽으로 회전
            for (int dir : new int[]{-1, 1}) {
                if (check(x1, y1 + dir) && check(x2, y2 + dir)) {
                    result.add(new Node(x1, y1, x1, y1 + dir, cnt + 1));
                    result.add(new Node(x2, y2, x2, y2 + dir, cnt + 1));
                }
            }
        }

        return result;
    }//getRotations end
    
    private static String makeKey(Node node) {
        int x1 = node.x1;
        int y1 = node.y1;
        int x2 = node.x2;
        int y2 = node.y2;

        // 두 칸의 순서가 바뀌어도 같은 상태로 보기 위해 정렬
        if (x1 > x2 || (x1 == x2 && y1 > y2)) {
            int tx = x1;
            int ty = y1;

            x1 = x2;
            y1 = y2;

            x2 = tx;
            y2 = ty;
        }

        return x1 + "," + y1 + "," + x2 + "," + y2;
    }//makeKey end
}//class end