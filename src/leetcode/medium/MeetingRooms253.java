package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/** 253. Meeting Rooms ||
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * */
class Intervals{
    int start;
    int end;
    Intervals(){ start=end=0; }
    Intervals(int s,int e){ this.start=s; this.end=e;}
}
public class MeetingRooms253 {
    public static int minMeeetingRooms(Intervals ints[]){
        if(ints == null || ints.length == 0)
            return 0;
        Arrays.sort(ints,(a,b)->a.start-b.start);
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Intervals> q = new PriorityQueue<>((a,b)->a.end-b.end);
        q.add(ints[0]);
        for(int i=1; i<ints.length;i++){

                Intervals current = ints[i];
                Intervals earliest = q.remove();
                if(current.start >= earliest.end){
                    earliest.end = current.start;
                }
                else
                {
                    q.add(current);
                }
                q.add(earliest);
        }
        return q.size();
    }
    public static int minimumMeetingRooms(Intervals ints[]){
        if(ints==null || ints.length==0)
            return 0;
        Arrays.sort(ints,(a,b)->a.start-b.start);
        PriorityQueue<Intervals> minHeap = new PriorityQueue<>((a,b)->a.end-b.end);
        minHeap.add(ints[0]);
        for(int i=1;i<ints.length;i++){
            Intervals current = ints[i];
            Intervals earliest = minHeap.remove();
            if(current.start >=earliest.end){
                earliest.end = current.start;
            }
            else minHeap.add(current);
            minHeap.add(earliest);
        }
        return  minHeap.size();
    }
    public static void main(String args[]){
        Intervals arr[] = new Intervals[3];
        arr[0] = new Intervals(0,30);
        arr[1] = new Intervals(5,10);
        arr[2] = new Intervals(15,20);
        System.out.println(minMeeetingRooms(arr));
    }
}
