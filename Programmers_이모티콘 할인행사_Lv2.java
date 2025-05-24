class Solution {
    
    int service = 0;
    int money = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] sale = new int[emoticons.length];
        combination(sale, 0, users, emoticons);
        
        int[] answer = {service, money};
        return answer;
    }
    
    void combination(int[] sale, int start, int[][] users, int[] emoticons) {
        if (start == sale.length) {
            calculate(sale, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            sale[start] = i;
            combination(sale, start + 1, users, emoticons);
        }
    }
    
    void calculate(int[] sale, int[][] users, int[] emoticons) {
        int serviceTmp = 0;
        int moneyTmp = 0;
        
        for (int[] user: users) {
            double amount = 0;
            
            for (int i = 0; i < emoticons.length; i++) {
                if (user[0] <= sale[i]) {
                    amount += (double)emoticons[i] * (100 - sale[i]) / 100;
                }
            }
            
            if (amount >= user[1]) {
                serviceTmp++;
            } else {
                moneyTmp += amount;
            }
        }
        
        if (serviceTmp > service) {
            service = serviceTmp;
            money = moneyTmp;
        } else if (serviceTmp == service && moneyTmp > money) {
            service = serviceTmp;
            money = moneyTmp;
        }
    }
}