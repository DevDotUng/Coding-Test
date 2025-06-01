import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int sum = 0;
        
        for (int i = score.length - 1; i >= score.length % m; i--) {
            sum++;
            
            if (sum % m == 0) {
                answer += sum * score[i];
                sum = 0;
            }
        }
        
        return answer;
    }
}