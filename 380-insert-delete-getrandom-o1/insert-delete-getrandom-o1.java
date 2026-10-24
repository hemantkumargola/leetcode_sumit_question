class RandomizedSet {

    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    Random rand = new Random();

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idx = map.get(val);
        int last = list.get(list.size() - 1);

        list.set(idx, last);
        map.put(last, idx);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}


// Insert:     O(1) average
// Remove:     O(1) average
// GetRandom:  O(1)
// Space:      O(n)