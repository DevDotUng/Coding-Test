import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Integer[] arr = new Integer[genres.length];
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            arr[i] = i;
            if (hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
            } else {
                hashMap.put(genres[i], plays[i]);
            }
        }
        
        Arrays.sort(arr, (i1, i2) -> genres[i1].equals(genres[i2]) ? plays[i1] == plays[i2] ? i1 - i2 : plays[i2] - plays[i1] : hashMap.get(genres[i2]) - hashMap.get(genres[i1]));
        
        List<Integer> list = new ArrayList<>();
        hashMap.clear();
        
        for (int a: arr) {
            if (hashMap.containsKey(genres[a])) {
                if (hashMap.get(genres[a]) < 2) {
                    list.add(a);
                    hashMap.put(genres[a], hashMap.get(genres[a]) + 1);
                }
            } else {
                list.add(a);
                hashMap.put(genres[a], 1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}