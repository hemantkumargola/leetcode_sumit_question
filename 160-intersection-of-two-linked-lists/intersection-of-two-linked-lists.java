
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Step 1: Agar koi bhi list empty hai,
        // to intersection possible nahi hai.
        if (headA == null || headB == null)
            return null;

        // ---------------------------------------------------
        // Step 2: Find length of List A
        // ---------------------------------------------------

        int lenA = 0;                 // Stores length of List A
        ListNode tempA = headA;       // Temporary pointer for traversal

        while (tempA != null) {
            lenA++;                   // Increase length
            tempA = tempA.next;       // Move to next node
        }

        // ---------------------------------------------------
        // Step 3: Find length of List B
        // ---------------------------------------------------

        int lenB = 0;                 // Stores length of List B
        ListNode tempB = headB;       // Temporary pointer for traversal

        while (tempB != null) {
            lenB++;                   // Increase length
            tempB = tempB.next;       // Move to next node
        }

        // ---------------------------------------------------
        // Step 4: Reset both pointers to starting position
        // ---------------------------------------------------

        tempA = headA;
        tempB = headB;

        // ---------------------------------------------------
        // Step 5: Move pointer of longer list ahead
        // so that both pointers have equal nodes remaining.
        // ---------------------------------------------------

        if (lenA > lenB) {

            // List A is longer
            int diff = lenA - lenB;

            for (int i = 0; i < diff; i++) {
                tempA = tempA.next;
            }

        } else {

            // List B is longer
            int diff = lenB - lenA;

            for (int i = 0; i < diff; i++) {
                tempB = tempB.next;
            }
        }

        // ---------------------------------------------------
        // Step 6: Move both pointers together
        // The first common node is the intersection node.
        // ---------------------------------------------------

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        // ---------------------------------------------------
        // Step 7:
        // If intersection exists -> return that node.
        // Otherwise both pointers become null,
        // so null is returned.
        // ---------------------------------------------------

        return tempA;
    }
}