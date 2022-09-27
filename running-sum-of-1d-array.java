class Solution {
    public int[] runningSum(int[] nums) {
        int[] array = new int[nums.length];
        array[0]  = nums[0];
        for(int index = 1; index < nums.length; index++){
            array[index] = nums[index] + array[index-1];
        }
        return array;
    }
}
