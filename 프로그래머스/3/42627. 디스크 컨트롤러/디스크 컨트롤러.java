import java.util.*;

class Node implements Comparable<Node> {
    int idx;
    int start;
    int during;

    public Node(int idx, int start, int during) {
        this.idx = idx;
        this.start = start;
        this.during = during;
    }

    @Override
    public int compareTo(Node o) {
        if (this.during != o.during) {
            return Integer.compare(this.during, o.during);
        }

        if (this.start != o.start) {
            return Integer.compare(this.start, o.start);
        }

        return Integer.compare(this.idx, o.idx);
    }
}

class Solution {
    public int solution(int[][] jobs) {

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            int start = jobs[i][0];
            int during = jobs[i][1];

            list.add(new Node(i, start, during));
        }

        list.sort((a, b) ->
            Integer.compare(a.start, b.start)
        );

        PriorityQueue<Node> q = new PriorityQueue<>();

        int idx = 0;
        int time = 0;
        int total = 0;
        int count = 0;
        
        while (count < jobs.length) {
            while (idx < jobs.length && list.get(idx).start <= time) {
                q.offer(list.get(idx));
                idx++;
            }

            if (!q.isEmpty()) {
                Node now = q.poll();

                time += now.during;

                total += time - now.start;

                count++;
            } else {
                time = list.get(idx).start;
            }
        }

        return total / jobs.length;
    }
}