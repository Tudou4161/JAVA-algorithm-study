package chap01;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        MeetingRoom2 a = new MeetingRoom2();

        Interval in1 = new Interval(0,30);
        Interval in2 = new Interval(4,9);
        Interval in3 = new Interval(10,16);
        Interval in4 = new Interval(5,15);

        Interval[] intervals = {in1, in2, in3, in4};
        System.out.println("a.solve(intervals) = " + a.solve(intervals));
    }

    public int solve(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> a.start-b.start);
        for (Interval interval : intervals) {
            System.out.println("interval = " + interval.start + " " + interval.end);
        }
        Queue<Interval> pq = new PriorityQueue<>((a,b) -> a.end-b.end); //우선순위 전제조건에 유의할 것!
        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek().end <= intervals[i].start) {
                System.out.println("pq.peek().start + \" \" + pq.peek().end = " + pq.peek().start + " " + pq.peek().end);
                pq.poll();
                pq.offer(intervals[i]);
            } else {
                pq.offer(intervals[i]);
            }
        }
        
        return pq.size();
    }
}
