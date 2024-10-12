/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            nodes.add(node);
            node = node.next;
        }
        if(nodes.size() -n - 1 >= 0){
            node = nodes.get(nodes.size() -n - 1);
            node.next = node.next.next;
        } else {
            return nodes.size() -n + 1 < nodes.size() ? nodes.get(nodes.size() - n + 1) : null;
        }
        return head;
    }
}