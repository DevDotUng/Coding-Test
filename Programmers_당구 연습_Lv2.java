class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int distance = m * m + n * n;
            
            int x = balls[i][0];
            int y = balls[i][1];
            
            if (startX != x || startY > y)
                distance = Math.min(distance, getDistance(startX, startY, x, 2 * n - y));
            
            if (startX != x || startY < y)
                distance = Math.min(distance, getDistance(startX, startY, x, -y));
            
            if (startY != y || startX > x)
                distance = Math.min(distance, getDistance(startX, startY, 2 * m - x, y));
            
            if (startY != y || startX < x)
                distance = Math.min(distance, getDistance(startX, startY, -x, y));
            
            answer[i] = distance;
        }
        
        return answer;
    }
    
    int getDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}