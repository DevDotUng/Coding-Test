import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        int answer = 0;
        
        for (int i = 0; i < n; i++)
            answer += bfs(i, visited, computers);
        
        return answer;
    }
    
    int bfs(int start, boolean[] visited, int[][] computers) {
        if (visited[start]) return 0;
        
        Queue<Integer> queue = new LinkedList<>();        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int i = 0; i < computers.length; i++) {
                if (i != current && !visited[i] && computers[current][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        
        return 1;
    }
}