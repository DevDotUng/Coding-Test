import java.util.List;
import java.util.ArrayList;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        List<Integer> sequence = new ArrayList<>();
        List<Double> integral = new ArrayList<>();
        sequence.add(k);
        
        while (k != 1) {
            int postK = k;
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            sequence.add(k);
            integral.add((postK + k) / 2.0);
        }
        
        int n = sequence.size() - 1;
        
        double[] answer = new double[ranges.length];
        
        for (int i = 0; i < ranges.length; i++) {
            
            double sum = 0;
            
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if (a > b) {
                answer[i] = -1;
                continue;
            }
            
            for (int j = a; j < b; j++) {
                sum += integral.get(j);
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}