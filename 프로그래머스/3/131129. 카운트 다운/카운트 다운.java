import java.util.*;

class Node{
    int score;
    int scoreBool;
    public Node(int score,int scoreBool){
        this.score = score;
        this.scoreBool = scoreBool;
    }
}

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        
        List<Node> list = new LinkedList<>();
        
        for(int i = 1; i <= 20; i++){
            list.add(new Node(i,1));
            list.add(new Node(i * 2,0));
            list.add(new Node(i * 3,0));
        }
        
        list.add(new Node(50,1));
        
        int[][] dp = new int[target + 1][2];
        
        for(int i = 1; i <= target; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for (int score = 1; score <= target; score++) {
            for (Node dart : list) {
                int dartScore = dart.score;
                int dartSingleOrBull = dart.scoreBool;

                // 수정: 현재 점수보다 큰 다트 점수는 사용할 수 없음
                if (score - dartScore < 0) {
                    continue;
                }

                int prevScore = score - dartScore;

                // 수정: 이전 점수를 만들 수 없는 상태라면 건너뜀
                if (dp[prevScore][0] == Integer.MAX_VALUE) {
                    continue;
                }

                int nextDartCount = dp[prevScore][0] + 1;
                int nextSingleOrBull = dp[prevScore][1] + dartSingleOrBull;

                // 수정: 다트 수가 더 적으면 갱신
                if (nextDartCount < dp[score][0]) {
                    dp[score][0] = nextDartCount;
                    dp[score][1] = nextSingleOrBull;
                }
                // 수정: 다트 수가 같으면 싱글 또는 불 횟수가 많은 쪽 선택
                else if (nextDartCount == dp[score][0]
                        && nextSingleOrBull > dp[score][1]) {
                    dp[score][1] = nextSingleOrBull;
                }
            }
        }
        
        return new int[] {dp[target][0],dp[target][1]};
    }//solution end
}//class end