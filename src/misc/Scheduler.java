package misc;

import java.util.*;
/*
* You are given a char array representing tasks CPU need to do.
* It contains capital letters A to Z where each letter represents a different task.
* Tasks needs to be done seq manner.
* Each task is done in one unit of time.
* You are give with cool down period of time which is equal to time cpu will wait before executing same task
* Input seq : ABAB
* cool down time :
*       coolDownMap.put('A',3);
        coolDownMap.put('B',2);
        coolDownMap.put('C',1);
        coolDownMap.put('D',2);
  Here 1st A will execute in 1 unit of time . Total Time = 1
  * 2nd B will execute in 1 unit .Total time = prev_total + 1 = 2
  * 3rd A = 2 + (3-1) + 1 = 5
  * 4th B 5+1 = 6
  * Output : 6
  * Seq AAA : output ->9
  * seq ABCD : output -> 4
  *
* */
public class Scheduler {
    public static int totalTime(Map<Character,Integer> coolDownMap,char[] tasks,int n){
        int total = 0;
        Map<Character,Integer> timeTracker = new HashMap<>();
        int prev=0;
        for(int i=0;i<tasks.length;i++){
           Integer prev_present = timeTracker.get(tasks[i]);
           if(prev_present==null){
               timeTracker.put(tasks[i],timeTracker.getOrDefault(tasks[i],0)+1);
               total+=1;
           }
           else{
               int cooldown = coolDownMap.get(tasks[i]).intValue();
               if(cooldown<prev_present)
               {
                   prev = total;
                   total+=1;
               }
               else{
                   prev=total;
                   total+=cooldown-prev+1;
                  // prev = prev1;
               }
            }
        }
        return total;
    }
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int m = tasks.length;
        int[] cnt = new int[26];
        /* Build the count array with frequency of each task */
        for (char c: tasks) {
            cnt[c - 'A']++;
        }
        Arrays.sort(cnt);
        /* Get maximum frequency task  and calculate max idle spaces*/
        int max = cnt[25]-1;
        int spaces = max * n;

        /* Iterate over rest of the array and reduce the idle space count */
        for (int i = 24; i >= 0; i--) {
            spaces -= Math.min(max, cnt[i]);
        }
        /* Handle cases when spaces become negative */
        spaces = Math.max(0, spaces);
        return tasks.length + spaces;
    }
    public static void main(String args[]){
        Map<Character,Integer> coolDownMap = new HashMap<>();
        coolDownMap.put('A',3);
        coolDownMap.put('B',2);
        coolDownMap.put('C',1);
        coolDownMap.put('D',2);
        System.out.println(totalTime(coolDownMap,"AAA".toCharArray(),3));
        System.out.println(leastInterval("AAA".toCharArray(),3));
    }
}
