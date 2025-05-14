import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        
        int[] start = new int[2];
        int[] labor = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'L') {
                    labor[0] = i;
                    labor[1] = j;
                } else if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        int countL = bfs(maps, start, 'L');
        int countE = bfs(maps, labor, 'E');
        
        if (countL == -1 || countE == -1) {
            return -1;
        } else {
            return countL + countE;
        }
    }
    
    int bfs(String[] maps, int[] start, char target) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        
        while(!queue.isEmpty()) {
            int[] xyc = queue.poll();
            int x = xyc[0];
            int y = xyc[1];
            int count = xyc[2];
            
            if (maps[x].charAt(y) == target) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length() && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    queue.add(new int[]{nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}