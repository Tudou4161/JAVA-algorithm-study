package chap02;

import java.util.Collection;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);
        while (node != null) {
            System.out.println("node.val = " + node.val);
            node = node.next;
        }
    }

    private static ListNode solve(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, newHead = new ListNode(0);
        ListNode p3 = newHead;
        int carry = 0;

        //두 연결리스트의 길이가 다를 수 있으므로 or조건으로 대처한다.
        while(p1 != null || p2 != null) {

            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }

        if (carry == 1) {
            p3.next = new ListNode(1);
        }

        return newHead.next; //복사는 p3가 하는데 왜 newHead를 반환하는거야...?
    }
}











//    private static ListNode solve(ListNode l1, ListNode l2) {
//        ListNode newHead = new ListNode(0);
//        ListNode p1 = l1, p2 = l2, p3 = newHead;
//
//        int carry = 0;
//        while (p1 != null || p2 != null) {
//            if (p1 != null) {
//                carry += p1.val;
//                p1 = p1.next;
//            }
//            if (p2 != null) {
//                carry += p2.val;
//                p2 = p2.next;
//            }
//
//            p3.next = new ListNode(carry % 10);
//            p3 = p3.next;
//            carry /= 10;
//        }
//
//        if (carry == 1) {
//            p3.next = new ListNode(1);
//        }
//
//        return newHead.next;
//    }