import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int first = -1;
        for (int[] target: targets) {
            if (first == -1) {
                answer++;
                first = target[1] - 1;
                continue;
            }
            
            if (first >= target[0] && first <= target[1]) {
                continue;
            }
            
            answer++;
            first = target[1] - 1;
        }
        
        return answer;
    }
}