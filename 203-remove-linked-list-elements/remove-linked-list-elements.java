class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 1. Trim all leading target nodes directly
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 2. Traversal without a dummy object
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}