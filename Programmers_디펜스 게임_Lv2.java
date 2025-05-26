import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        int nTmp = n;
        int i = 0;
        
        for (i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            nTmp -= enemy[i];
            
            if (nTmp < 0) {
                if (k > 0) {
                    nTmp += pq.poll();
                    k--;
                } else {
                    break;
                }
            }
        }
        
        int answer = i;
        
        return answer;
    }
}