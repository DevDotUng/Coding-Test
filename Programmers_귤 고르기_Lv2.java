import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        
        for (int t: tangerine) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        
        for (int key: map.keySet()) {
            pq.offer(map.get(key));
        }
        
        while (k > 0) {
            k -= pq.poll();
            answer++;
        }
        
        return answer;
    }
}