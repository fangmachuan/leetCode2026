package basic;

public class ListNodeCode {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //删除链表中的节点
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public class ListNode1 {
        int val;
        ListNode next;

        ListNode1() {
        }

        ListNode1(int val) {
            this.val = val;
        }

        ListNode1(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //删除链表的倒数第N个节点
    static class Solution1 {
        public ListNode removeNthFromEnd(ListNode1 head, int n) {
            while (n == 0){

                n--;
            }



            head.val = head.next.val;
            head.next = head.next.next;
        }
    }
}
