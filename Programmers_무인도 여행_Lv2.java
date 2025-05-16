import java.util.*;

class Solution {
    
    int[][] MAP;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        
        MAP = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    MAP[i][j] = 0;
                } else {
                    MAP[i][j] = maps[i].charAt(j) - 48;
                }
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[0].length; j++) {
                if (MAP[i][j] != 0) {
                    answerList.add(bfs(new int[]{i, j}));
                }
            }
        }
        
        if (answerList.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    int bfs(int[] start) {
        int count = MAP[start[0]][start[1]];
        MAP[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});
        
        while(true) {
            if (queue.isEmpty()) {
                return count;
            }
            
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < MAP.length && ny >= 0 && ny < MAP[0].length && MAP[nx][ny] != 0) {
                    queue.add(new int[]{nx, ny});
                    count += MAP[nx][ny];
                    MAP[nx][ny] = 0;
                }
            }
        }
    }
}