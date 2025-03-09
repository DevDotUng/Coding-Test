import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((i1, i2) -> (i1 - i2));

        for (int i = 0; i < n; i++) {
            if (maxQueue.size() == minQueue.size()) {
                maxQueue.offer(Integer.parseInt(br.readLine()));
            } else {
                minQueue.offer(Integer.parseInt(br.readLine()));
            }

            if (!minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
                int max = maxQueue.poll();
                int min = minQueue.poll();
                minQueue.offer(max);
                maxQueue.offer(min);
            }

            sb.append(maxQueue.peek());
            if (i < n - 1) sb.append("\n");
        }

        System.out.println(sb);
    }
}