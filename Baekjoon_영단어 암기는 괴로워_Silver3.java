import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                if (hashMap.containsKey(input)) hashMap.put(input, hashMap.get(input) + 1);
                else hashMap.put(input, 1);
            }
        }

        PriorityQueue<WordCount> pq = new PriorityQueue<>((w1, w2) -> (w1.count != w2.count ? w2.count - w1.count : w1.word.length() != w2.word.length() ? w2.word.length() - w1.word.length() : w1.word.compareTo(w2.word)));

        for (String word: hashMap.keySet()) {
            pq.offer(new WordCount(word, hashMap.get(word)));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll().word).append("\n");
        }

        System.out.println(sb);
    }
}

class WordCount {
    String word;
    int count;

    WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
}