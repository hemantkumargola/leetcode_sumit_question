
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // fast.next!=nul&&fast !=null  ye condition wrong hai 
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
        
    }
}