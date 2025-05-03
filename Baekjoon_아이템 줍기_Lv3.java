class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    int iX = 0;
    int iY = 0;
    
    int count = -1;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        boolean[][] visited = new boolean[52][52];
        
        iX = itemX;
        iY = itemY;
        
        dfs(0, visited, characterX, characterY, rectangle);
        
        return count;
    }
    
    public void dfs(int depth, boolean[][] visited, int x, int y, int[][] rectangle) {
        if (x == iX && y == iY) {
            if (count < 0 || depth < count) {
                count = depth;
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (!visited[nextX][nextY] && isRoad(rectangle, nextX, nextY, x, y)) {
                visited[nextX][nextY] = true;
                dfs(depth + 1, visited, nextX, nextY, rectangle);
                visited[nextX][nextY] = false;
            }
        }
    }
    
    public boolean isRoad(int[][] rectangle, int x, int y, int preX, int preY) {
        for (int[] r: rectangle) {
            if (isIn(r, x, y)) {
                return false;
            }
        }
        
        for (int[] r: rectangle) {
            if (isCross(r, x, y, preX, preY)) {
                return false;
            }
        }
        
        for (int[] r: rectangle) {
            if (isLine(r, x, y) && !isPass(r, x, y, preX, preY)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isLine(int[] rectangle, int x, int y) {
        if ((rectangle[0] == x || rectangle[2] == x) && (rectangle[1] <= y && rectangle[3] >= y)) {
            return true;
        } else if ((rectangle[0] <= x && rectangle[2] >= x) && (rectangle[1] == y || rectangle[3] == y)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isLine(int[] rectangle, double x, double y) {
        if ((rectangle[0] == x || rectangle[2] == x) && (rectangle[1] <= y && rectangle[3] >= y)) {
            return true;
        } else if ((rectangle[0] <= x && rectangle[2] >= x) && (rectangle[1] == y || rectangle[3] == y)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isIn(int[] rectangle, int x, int y) {
        if ((rectangle[0] < x && rectangle[2] > x) && (rectangle[1] < y && rectangle[3] > y)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isCross(int[] rectangle, int x, int y, int preX, int preY) {
        double midX = (double)(x + preX) / 2;
        double midY = (double)(y + preY) / 2;
        
        if ((rectangle[0] < midX && rectangle[2] > midX) && (rectangle[1] < midY && rectangle[3] > midY)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPass(int[] rectangle, int x, int y, int preX, int preY) {
        double midX = (double)(x + preX) / 2;
        double midY = (double)(y + preY) / 2;
        
        if (isLine(rectangle, midX, midY)) {
            return false;
        } else {
            return true;
        }
    }
}