class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] arr = new int[y + 1];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -2;
        }
        
        arr[x] = 0;
        
        if (x == y) {
            return 0;
        }
        
        for (int i = x + 1; i <= y; i++) {
            int num1 = i - n < 0 ? 0 : i - n;
            int num2 = i % 2 == 0 ? i / 2 : 0;
            int num3 = i % 3 == 0 ? i / 3 : 0;
            
            int num = 1000000;
            
            if (arr[num1] >= 0) {
                num = arr[num1];
            }
            
            if (arr[num2] >= 0) {
                if (arr[num2] < num) {
                    num = arr[num2];
                }
            }
            
            if (arr[num3] >= 0) {
                if (arr[num3] < num) {
                    num = arr[num3];
                }
            }
            
            if (num != 1000000) {
                arr[i] = num + 1;
            } else {
                arr[i] = -1;
            }
        }
        
        return arr[y];
    }
}