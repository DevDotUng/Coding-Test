class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int index = -1;
        int count = 1;
        int floor = n % w == 0 ? n / w : n / w + 1;
        
        for (int i = 0; i < floor; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    if (count > n) break;
                    
                    if (count == num) {
                        index = j;
                        answer++;
                    } else if (j == index) {
                        answer++;
                    }
                    
                    count++;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    if (count > n) break;
                    
                    if (count == num) {
                        index = j;
                        answer++;
                    } else if (j == index) {
                        answer++;
                    }
                    
                    count++;
                }
            }
        }
        
        return answer;
    }
}