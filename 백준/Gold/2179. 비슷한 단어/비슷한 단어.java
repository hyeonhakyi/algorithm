import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Word{
        String word;
        int idx;

        public Word(String word, int idx){
            this.word = word;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] original = new String[n];
        Word[] words = new Word[n];
        for(int i = 0; i < n; i++){
            String line = br.readLine().trim();
            original[i] = line;
            words[i] = new Word(line, i);
        }

        Word[] sorted = words.clone();
        Arrays.sort(sorted, Comparator.comparing(w -> w.word));

        int[] lcp = new int[n-1];
        int maxLength = 0;
        for(int i = 0; i < n - 1; i++){
            lcp[i] = LCP(sorted[i].word, sorted[i+1].word);
            maxLength = Math.max(maxLength, lcp[i]);
        }

        int bestFirst = Integer.MAX_VALUE;
        int bestSecond = Integer.MAX_VALUE;

        for(int i = 0; i < n-1;){
            if(lcp[i] != maxLength) {
                i++;
                continue;
            }

            int j = i;
            while(j < n - 1 && lcp[j] == maxLength) j++;

            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;

            for(int k = i; k <= j; k++){
                int idx = sorted[k].idx;
                if(idx < first){
                    second = first;
                    first = idx;
                }else if(idx < second){
                    second = idx;
                }
            }

            if(first < bestFirst || (first == bestFirst && second < bestSecond)){
                bestFirst = first;
                bestSecond = second;
            }
            i = j;
        }

        System.out.println(original[bestFirst]);
        System.out.println(original[bestSecond]);
    }//main end

    static int LCP(String a, String b){
        int length = Math.min(a.length(), b.length());
        int count = 0;
        while(count < length && a.charAt(count) == b.charAt(count)) count++;
        return count;
    }
}//class end
