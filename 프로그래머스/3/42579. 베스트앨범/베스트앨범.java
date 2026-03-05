import java.util.*;

class Solution {
    static class Song {
        int id;
        int play;
        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1) 장르별 총 재생수
        Map<String, Integer> total = new HashMap<>();
        // 2) 장르별 노래 목록
        Map<String, List<Song>> songs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            total.put(g, total.getOrDefault(g, 0) + p);
            songs.computeIfAbsent(g, k -> new ArrayList<>()).add(new Song(i, p));
        }

        // 3) 장르를 총 재생수 내림차순으로 정렬
        List<String> order = new ArrayList<>(total.keySet());
        order.sort((a, b) -> Integer.compare(total.get(b), total.get(a)));

        List<Integer> result = new ArrayList<>();

        // 4) 각 장르에서 상위 2곡 뽑기
        for (String g : order) {
            List<Song> list = songs.get(g);
            list.sort((s1, s2) -> {
                if (s1.play != s2.play) return Integer.compare(s2.play, s1.play); // 재생수 내림차순
                return Integer.compare(s1.id, s2.id); // id 오름차순
            });

            result.add(list.get(0).id);
            if (list.size() >= 2) result.add(list.get(1).id);
        }

        // 5) int[]로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}