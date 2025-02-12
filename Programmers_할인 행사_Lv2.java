import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            if (map.containsKey(discount[i])) {
                int[] numberTmp = new int[number.length];
                for (int j = 0; j < number.length; j++) {
                    numberTmp[j] = number[j];
                }
                
                for (int j = i; j < i + 10; j++) {
                    if (map.containsKey(discount[j])) numberTmp[map.get(discount[j])]--;
                }
                
                if (isAllSale(numberTmp)) answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isAllSale(int[] number) {
        for (int n: number) {
            if (n != 0) return false;
        }
        
        return true;
    }
}