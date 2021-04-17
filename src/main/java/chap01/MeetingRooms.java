package chap01;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;

    //생성자에 값이 안들어오면, 0으로 기본 값 세팅!
    Interval(){
        this.start = 0;
        this.end = 0;
    }

    //생성자에 값이 들어오면, 값을 받아서 그대로 처리!
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class MeetingRooms {

    public static void main(String[] args) {
        MeetingRooms a = new MeetingRooms();

        Interval in1 = new Interval(15, 20);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(0, 30);
        Interval in4 = new Interval(5, 8);

//        Interval in1 = new Interval(7, 10);
//        Interval in2 = new Interval(2, 4);

        Interval[] intervals = {in1, in2, in3, in4};
        //Interval[] intervals = {in1, in2};
        System.out.println(a.solve(intervals));

    }

    public boolean solve(Interval[] intervals) {
        //1. Null check!
        if (intervals == null) return false;
        //2.Comp를 기준으로 정렬 (오름차순 정렬)
        Arrays.sort(intervals, Comp);
        print(intervals);
        //3. iter
        //정렬 후, 첫 번째 원소의 end값과 for문으로 받아온 start값을 비교하고,
        //end가 계속 크면, false를 반환한다.
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }

    Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            //return o1.start -o2.start;
            // start와 end 모두 오름차순 정렬을 진행한다.
            // Comparator 클래스를 활용해서 조건문을 사용해 처리.
            // return 1이면 자리가 바뀌고, 0이나 음수면 자리가 안바뀐다.
            if (o1.start > o2.start) {
                return 1;
            }
            else if (o1.start == o2.start) {
                if (o1.end > o2.end) {
                    return 1;
                }
            }
            return -1;
        }
    };


    public void print(Interval[] intervals) {
        for(int i = 0; i<intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start + " " + in.end);
        }
    }
}
