package leetcode.easy;

import java.util.*;

/** 448. Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 * */

public class FindMissingNumbers448 {
    public static List<Integer> findMissingNums(int nums[]){
        Set<Integer> numbers = new HashSet<>();
        List<Integer> missingNums = new ArrayList<>();
        for(int i: nums)
            numbers.add(i);
        for(int i=1; i<=nums.length;i++)
            if(!numbers.contains(i))
                missingNums.add(i);
        return missingNums;
    }
    public static void main(String args[]){
        int [] input = {4,3,2,7,8,2,3,1};
        List<Integer> output = findMissingNums(input);
        System.out.println(Arrays.toString(output.toArray()));
    }
}
