import java.util.*;

class Node implements Comparable<Node> {
    int idx;    // 작업 번호
    int start;  // 요청 시각
    int work;   // 소요 시간

    public Node(int idx, int start, int work) {
        this.idx = idx;
        this.start = start;
        this.work = work;
    }

    @Override
    public int compareTo(Node o) {
        // 수정: 우선순위는 소요시간 -> 요청시각 -> 작업번호
        if (this.work == o.work) {
            if (this.start == o.start) {
                return Integer.compare(this.idx, o.idx);
            }
            return Integer.compare(this.start, o.start);
        }
        return Integer.compare(this.work, o.work);
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(i, jobs[i][0], jobs[i][1]);
        }

        // 수정: 요청 시각 순으로 먼저 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a.start == b.start) {
                return Integer.compare(a.idx, b.idx);
            }
            return Integer.compare(a.start, b.start);
        });

        PriorityQueue<Node> pq = new PriorityQueue<>();

        long time = 0;   // 수정: 현재 시각
        long sum = 0;    // 수정: 반환 시간 총합
        int ptr = 0;     // 수정: 아직 pq에 넣지 않은 작업의 위치
        int done = 0;    // 수정: 처리 완료한 작업 수

        while (done < n) {
            // 수정: 현재 시각까지 요청된 작업들을 pq에 넣기
            while (ptr < n && arr[ptr].start <= time) {
                pq.offer(arr[ptr]);
                ptr++;
            }

            // 수정: 대기 중인 작업이 없다면 다음 요청 시각으로 점프
            if (pq.isEmpty()) {
                time = arr[ptr].start;
                continue;
            }

            // 수정: 우선순위가 가장 높은 작업 실행
            Node now = pq.poll();
            time += now.work;
            sum += (time - now.start);
            done++;
        }

        return (int)(sum / n);
    }//solution end
}