import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String now = words[i];

            boolean isDuplicate = set.contains(now);

            boolean isWrongChain = prev.charAt(prev.length() - 1) != now.charAt(0);

            if (isDuplicate || isWrongChain) {
                int person = (i % n) + 1;
                int turn = (i / n) + 1;

                return new int[]{person, turn};
            }

            set.add(now);
        }

        return new int[]{0, 0};
    }//solution end
}//class end