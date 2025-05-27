class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i <= d; i += k) {
            answer += (int)(getY(i, d) / k) + 1;
        }
        
        return answer;
    }
    
    double getY(long x, long d) {
        return Math.sqrt(d*d - x*x);
    }
}