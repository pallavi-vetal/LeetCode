package leetcode.easy;
/*
* Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
* Return the running sum of nums.
* */
public class Sum1DArray1480 {
    //complexity o(n^2)
    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        // res[0] = nums[0];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=i;j++)
                res[i] +=nums[j];
        }
        return res;
    }
    //optimize
    public static int[] runningSumV2(int[] nums){

        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
    public static void main(String args[]){
        int[] input = {1,2,3,4};
        int res[] = runningSum(input); //Expected output 1,3,6,10
        for(int i:res)
            System.out.print(i+"\t");
        res = runningSumV2(input); //Expected output 1,3,6,10
        System.out.println("\nV2: \n");
        for(int i:res)
            System.out.print(i+"\t");
    }
}
