import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] cards) {
        
        List<Integer> groups = new ArrayList<>();
        boolean[] visited = new boolean[cards.length];
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                
                int count = 0;
                int now = i;
                
                while (!visited[now]) {
                    count++;
                    visited[now] = true;
                    now = cards[now] - 1;
                }
                
                groups.add(count);
            }
        }
        
        if (groups.size() == 1) {
            return 0;
        }
        
        Collections.sort(groups, Collections.reverseOrder());
        
        int answer = groups.get(0) * groups.get(1);
        return answer;
    }
}