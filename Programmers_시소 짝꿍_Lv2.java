import java.util.*;

class Solution { 
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        HashMap<Double, Integer> weightsMap = new HashMap<>();
        
        for (int w: weights) {
            double w1 = w;
            double w2 = (double)w * 2 / 3;
            double w3 = (double)w / 2;
            double w4 = (double)w * 3 / 4;
            
            if (weightsMap.containsKey(w1)) answer += weightsMap.get(w1);
            if (weightsMap.containsKey(w2)) answer += weightsMap.get(w2);
            if (weightsMap.containsKey(w3)) answer += weightsMap.get(w3);
            if (weightsMap.containsKey(w4)) answer += weightsMap.get(w4);
            
            if (weightsMap.containsKey(w1)) {
                weightsMap.put(w1, weightsMap.get(w1) + 1);
            } else {
                weightsMap.put(w1, 1);
            }
        }
        
        return answer;
    }
}