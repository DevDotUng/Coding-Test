class Solution {
    
    int count = 0;
    
    public int solution(int[] number) {
        
        permutation(0, number, number.length);
        
        int answer = count / 6;
        return answer;
    }
    
    public void permutation(int depth, int[] number, int n) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += number[i]; 
            }
            
            if (sum == 0) count++;
            
            return;
        }
        
        for (int i = depth; i < n; i++) {
            swap(number, depth, i);
            permutation(depth + 1, number, n);
            swap(number, depth, i);
        }
    }
    
    public void swap(int[] number, int i, int j) {
        int tmp = number[i];
        number[i] = number[j];
        number[j] = tmp;
    }
}