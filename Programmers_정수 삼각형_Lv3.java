class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][triangle.length];
        
        for (int i = 0; i < triangle.length; i++) {
            dp[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }
        
        for (int i = triangle.length - 1; i >= 0; i--) {
            for (int j = 1; j < triangle[i].length; j++) {
                if (dp[i][j - 1] > dp[i][j]) {
                    dp[i - 1][j - 1] = dp[i][j - 1] + triangle[i - 1][j - 1];
                } else {
                    dp[i - 1][j - 1] = dp[i][j] + triangle[i - 1][j - 1];
                }
            }
        }
        
        return dp[0][0];
    }
}