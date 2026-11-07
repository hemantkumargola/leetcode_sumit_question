
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.remove();

                if (curr.equals(endWord)) {
                    return steps;
                }

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;

                        String next = new String(arr);

                        if (set.contains(next)) {

                            q.add(next);
                            set.remove(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}
