package leetcode.easy;

public class RemoveDupsFromSortedArray26 {
    public static int removeDuplicates(int[] nums) {
       int index = 1;
       for(int i=0;i<nums.length-1; i++){
           if(nums[i]!=nums[i+1])
               nums[index++] = nums[i+1];
       }
       return index;
    }
    public static void main(String args[]){
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(arr);
        for(int i=0;i<len;i++)
            System.out.println(arr[i]);
    }
}
