class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String storeyString = Integer.toString(storey);
        int[] storeyArr = new int[storeyString.length()];
        
        for (int i = 0; i < storeyArr.length; i++) {
            storeyArr[i] = storeyString.charAt(i) - 48;
        }
        
        for (int i = storeyString.length() - 1; i >= 1; i--) {
            if (storeyArr[i] < 5) {
                answer += storeyArr[i];
            } else if (storeyArr[i] > 5) {
                answer += 10 - storeyArr[i];
                storeyArr[i - 1]++;
            } else {
                if (storeyArr[i - 1] >= 5) {
                    answer += 10 - storeyArr[i];
                    storeyArr[i - 1]++;
                } else {
                    answer += storeyArr[i];
                }
            }
        }
        
        if (storeyArr[0] <= 5) {
            answer += storeyArr[0];
        } else {
            answer += 11 - storeyArr[0];
        }
        
        return answer;
    }
}