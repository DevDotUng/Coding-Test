import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0); map.put('T', 0); map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0); map.put('A', 0); map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            
            if (choices[i] < 4) {
                map.put(first, map.get(first) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                map.put(second, map.get(second) + choices[i] - 4);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}