package basic;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.Stack;

public class ListNodeCode {


    public class ListNode2 {
        int val;
        ListNode2 next;

        ListNode2(int x) {
            val = x;
        }
    }

    //删除链表中的节点
    static class Solution {
        public void deleteNode(ListNode2 node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //删除链表的倒数第N个节点
    static class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = head;
            int last = length(head) - n;
            //如果last等于0表示删除的是头结点
            if (last == 0)
                return head.next;
            //这里首先要找到要删除链表的前一个结点
            for (int i = 0; i < last - 1; i++) {
                pre = pre.next;
            }
            //然后让前一个结点的next指向要删除节点的next
            pre.next = pre.next.next;
            return head;
        }

        //求链表的长度
        private int length(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        }
    }


    //反转链表
    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode newListNode = new ListNode();
            Stack<ListNode> stack = new Stack<>();
            while (head != null){
                stack.push(head);
                head = head.next;
            }
            newListNode = stack.pop();
            ListNode dummy = newListNode;
            while (!stack.isEmpty()){
                ListNode pop = stack.pop();
                newListNode.next = pop;
                newListNode = newListNode.next;
            }
            newListNode.next = null;
            return dummy;
        }

        public static void main(String[] args) {
            System.out.println(new Solution2().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        }
    }


    //合并两个有序链表

    static class Solution3 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

    //回文链表
    static class Solution4 {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null){
                return true;
            }
            Stack<ListNode> stack =  getStock(head);
            while (!stack.isEmpty()){
                if (stack.pop().val != head.val){
                    return false;
                }else {
                    head = head.next;
                }
            }
            return true;

        }

        private Stack<ListNode> getStock(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            while (head != null){
                stack.push(head);
                head = head.next;
            }
            return stack;
        }

        public static void main(String[] args) {
            System.out.println(new Solution4().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        }
    }


    //环形链表
    static class Solution5 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null){
                return false;
            }
            ListNode slow  = head;
            ListNode fast = head;
            while (head != null){
                slow = slow.next;
                if (slow == null || fast.next == null){
                    return false;
                }
                fast = fast.next.next;
                if (fast == null){
                    return false;
                }
                if (slow == fast){
                    return true;
                }
            }
            return false;
        }
    }

}
