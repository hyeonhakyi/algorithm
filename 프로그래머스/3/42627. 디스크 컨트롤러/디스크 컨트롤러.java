import java.util.*;

class Job {
    int idx;
    int start;
    int duration;

    public Job(int idx, int start, int duration) {
        this.idx = idx;
        this.start = start;
        this.duration = duration;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        Job[] arr = new Job[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }

        // 1. 요청 시각 기준 정렬
        Arrays.sort(arr, (a, b) ->
            Integer.compare(a.start, b.start)
        );

        // 2. 소요 시간 기준 우선순위 큐
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.duration != b.duration) {
                return Integer.compare(a.duration, b.duration);
            }

            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }

            return Integer.compare(a.idx, b.idx);
        });

        int time = 0;
        int idx = 0;
        int total = 0;
        int count = 0;

        while (count < n) {

            // 3. 현재 시간까지 요청된 작업 추가
            while (idx < n && arr[idx].start <= time) {
                pq.offer(arr[idx]);
                idx++;
            }

            // 4. 대기 중인 작업이 있다면 실행
            if (!pq.isEmpty()) {
                Job now = pq.poll();

                time += now.duration;
                total += time - now.start;

                count++;
            } else {
                // 5. 대기 작업이 없다면 다음 요청 시각으로 이동
                time = arr[idx].start;
            }
        }

        return total / n;
    }
}