class Solution {
    public int wateringPlants(int[] plants, int capacity) {

        int water = capacity;
        int steps = 0;

        for (int i = 0; i < plants.length; i++) {

            // Agar current plant ke liye water kam hai
            if (water < plants[i]) {
                steps += i * 2; // River par wapas + current plant tak
                water = capacity;
            }

            // Current plant par ek step
            steps++;

            // Water the plant
            water -= plants[i];
        }

        return steps;
    }
}