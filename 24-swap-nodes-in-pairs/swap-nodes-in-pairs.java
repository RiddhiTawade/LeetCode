
class Solution {

    public ListNode swapPairs(ListNode head) {

        // Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null &&
               current.next.next != null) {

            // First node
            ListNode first = current.next;

            // Second node
            ListNode second = first.next;

            // Swap the nodes
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        return dummy.next;
    }
}
