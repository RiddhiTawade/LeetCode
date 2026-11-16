
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int count = 0; count < n; count++) {
            fast = fast.next;
        }

        // Move both pointers together
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the required node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
