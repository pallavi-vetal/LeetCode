package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
* 1512. Number of Good Pairs
* Given an array of integers nums.
* A pair (i,j) is called good if nums[i] == nums[j] and i < j.
* Return the number of good pairs.
* Example 1:
* Input: nums = [1,2,3,1,1,3]
* Output: 4
* Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
*/
public class SamePairs1512 {

    //Naive approach
    public static int getCountSolution1(int[] nums){
        int count = 0;
        for(int i=0; i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]==nums[j])    count+=1;
        }
        return count;
    }
    //using map
    public static int getCountSolution2(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count += map.getOrDefault(nums[i],0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
    public static void main(String args[]){
        int input[] = {1,2,3,1,1,3};
        System.out.println(getCountSolution1(input));
        input = new int[]{1, 1, 1, 1};
        System.out.println(getCountSolution2(input));
    }
}
