package chap01;

import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval a = new MergeInterval();

        Interval in1 = new Interval(1,3);
        Interval in2 = new Interval(2,6);
        Interval in3 = new Interval(8,10);
        Interval in4 = new Interval(15,18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        List<Interval> list = a.merge(intervals);

        a.print(list);

    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, (a,b) -> a.start-b.start);
        for (Interval interval : intervals) {
            System.out.println("interval.start = " + interval.start + " interval.end = " + interval.end);
        }
        Interval before = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (before.end > current.start){
                System.out.println("before = " + before.start + " " + before.end);
                before.end = Math.max(before.end, current.end);
            } else { //else 문에 반드시 걸려야함.
                result.add(before);
                before = current;
                System.out.println("before = " + before.start + " " + before.end);
            }
        }

        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    private void print(List<Interval> list) {
        for (int i=0; i<list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start + " : " + in.end);
        }
    }
}
