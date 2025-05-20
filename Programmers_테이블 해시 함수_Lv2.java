import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i2[col - 1] == i1[col - 1] ? i2[0] - i1[0] : i1[col - 1] - i2[col - 1];
            }
        });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int s_i = 0;
            for (int j = 0; j < data[0].length; j++) {
                s_i += data[i][j] % (i + 1);
            }
            answer ^= s_i;
        }
        
        return answer;
    }
}