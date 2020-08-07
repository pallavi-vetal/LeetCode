package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/** 1. Two Sum

 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 **/
public class TwoSum1 {
    public static int[] findSum(int nums[],int target){
        int res[] = new int[2];
        if(nums.length==0 || nums == null)
            return res;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);

        for(int i=0;i<nums.length;i++){
            int comp = target - nums[i];
            if(map.containsKey(comp) && map.get(comp)!=i)
            {
                res[0] = i;
                res[1] = map.get(comp);
            }
        }
        return  res;
    }
    public static void main(String args[]){
        int input[] = {1,2,3,4};
        int res[] = findSum(input,5);
        for(int i:res){
            System.out.print(i);
        }

    }
}
