public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        int loA = 0;
        ListNode tempA = headA;

        while(tempA != null){
            loA++;
            tempA = tempA.next;
        }

        int loB = 0;
        ListNode tempB = headB;

        while(tempB != null){
            loB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if(loA > loB){
            for(int i = 0; i < loA - loB; i++){
                tempA = tempA.next;
            }
        }else{
            for(int i = 0; i < loB - loA; i++){
                tempB = tempB.next;
            }
        }

        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;   // ✅ Correct
    }
}