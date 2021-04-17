package chap02;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        MergeKSortedList a = new MergeKSortedList();
        ListNode result = a.solve(list);
        System.out.println("====");
        while (result != null) {
            System.out.println("result.val = " + result.val);
            //System.out.println("result.next = " + result.next.val);
            result = result.next;
        }
    }

    Comparator<ListNode> Comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
        }
    };

    public ListNode solve(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comp);

        ListNode[] list = lists;
        ListNode newHead = new ListNode(0), p3 = newHead;

        for (ListNode listNode : list) {
            pq.offer(listNode);
        }

        while (!pq.isEmpty()) {
            ListNode pollNode = pq.poll();
            p3.next = new ListNode(pollNode.val);
            p3 = p3.next;

            if(pollNode.next != null) {
                pq.offer(pollNode.next);
            }
        }
        return newHead.next;
    }
}








//    PriorityQueue<ListNode> q = new PriorityQueue<>(Comp);
//    ListNode newHead = new ListNode(0);
//    ListNode p = newHead;
//
//        for (ListNode node : lists) {
//                if (node != null) {
//                System.out.println("node.val = " + node.val);
//                q.offer(node);
//                }
//                }
//
//                while (!q.isEmpty()) {
//                System.out.println("q.peek().val = " + q.peek().val);
//                ListNode node = q.poll(); //원소 빼오기.
//                p.next = node; //결과 헤드에 값 찍어주기.
//                p = p.next; //결과 헤드 포인터 이동
//
//                if (node.next != null) {
//                q.offer(node.next); //꺼내온 노드의 next값들을 다시 큐에 넣어주기.
//                }
//                }
//
//                return newHead.next;
//                }
//
//
//                Comparator<ListNode> Comp = new Comparator<ListNode>() {
//@Override
//public int compare(ListNode o1, ListNode o2) {
//        return o1.val-o2.val;
//        }
//        };
