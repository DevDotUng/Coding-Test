class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 0;
        
        int[] wall = new int[n];
        
        for (int i = 0; i < section.length; i++) {
            wall[section[i] - 1] = 1;
        }
        
        int i = 0;
        for (i = 0; i < n - m + 1; i++) {
            if (wall[i] == 1) {
                answer++;
                i += m - 1;
            }
        }
        
        for (i = i; i < n; i++) {
            if (wall[i] == 1) {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}