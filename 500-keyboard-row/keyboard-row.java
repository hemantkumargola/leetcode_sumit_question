class Solution {
    public String[] findWords(String[] words) {

        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        ArrayList<String> ans = new ArrayList<>();

        for (String word : words) {

            String lower = word.toLowerCase();

            for (String row : rows) {

                boolean possible = true;

                for (char ch : lower.toCharArray()) {
                    if (row.indexOf(ch) == -1) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    ans.add(word);
                    break;
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}