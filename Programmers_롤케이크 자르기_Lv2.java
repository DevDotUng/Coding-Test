import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        HashMap<Integer, Integer> cMap = new HashMap<>();
        HashMap<Integer, Integer> bMap = new HashMap<>();
        
        for (int t: topping) {
            
            queue.add(t);
            
            if (bMap.containsKey(t)) {
                bMap.put(t, bMap.get(t) + 1);
            } else {
                bMap.put(t, 1);
            }
        }
        
        while (!queue.isEmpty()) {
            
            int t = queue.poll();
            
            if (cMap.containsKey(t)) {
                cMap.put(t, cMap.get(t) + 1);
            } else {
                cMap.put(t, 1);
            }
            
            if (bMap.get(t) > 1) {
                bMap.put(t, bMap.get(t) - 1);
            } else {
                bMap.remove(t);
            }
            
            if (cMap.size() == bMap.size()) answer++;
        }
        
        return answer;
    }
}