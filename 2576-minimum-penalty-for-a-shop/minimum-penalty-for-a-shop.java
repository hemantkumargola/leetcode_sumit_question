class Solution {
    public int bestClosingTime(String customers) {

        int penalty = 0;

    
        for (char ch : customers.toCharArray()) {
            if (ch == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int answer = 0;

        for (int i = 0; i < customers.length(); i++) {

            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                answer = i + 1;
            }
        }

        return answer;
    }
}