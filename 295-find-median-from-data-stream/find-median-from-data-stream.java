
import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {

        // Max Heap
        small = new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        small.offer(num);

        // Move largest element of small to large
        large.offer(small.poll());

        // Balance heap sizes
        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}
