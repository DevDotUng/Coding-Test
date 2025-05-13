import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    
    public int solution(String[] board) {
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        int[] start = new int[3];
        start[2] = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        int answer = bfs(start, visited, board);
        
        return answer;
    }
    
    public int bfs(int[] start, boolean[][] visited, String[] board) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            
            int[] startTmp = queue.poll();
            
            int x = startTmp[0];
            int y = startTmp[1];
            int count = startTmp[2];
            
            if (board[x].charAt(y) == 'G') {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                
                int nx = x;
                int ny = y;
                
                while (true) {
                    if (i == 0) {
                        if (nx <= 0 || board[nx - 1].charAt(ny) == 'D') {
                            break;
                        }
                        
                        nx += dx[i];
                        ny += dy[i];
                    } else if (i == 1) {
                        if (nx >= board.length - 1 || board[nx + 1].charAt(ny) == 'D') {
                            break;
                        }
                        
                        nx += dx[i];
                        ny += dy[i];
                    } else if (i == 2) {
                        if (ny <= 0 || board[nx].charAt(ny - 1) == 'D') {
                            break;
                        }
                        
                        nx += dx[i];
                        ny += dy[i];
                    } else if (i == 3) {
                        if (ny >= board[0].length() - 1 || board[nx].charAt(ny + 1) == 'D') {
                            break;
                        }
                        
                        nx += dx[i];
                        ny += dy[i];
                    }
                }
                
                if (!visited[nx][ny]) {
                    queue.add(new int[] {nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}