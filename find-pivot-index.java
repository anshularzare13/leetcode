/**
  Problem -> https://leetcode.com/problems/find-pivot-index/submissions/
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        
        leftSum[0] = 0;
        rightSum[len-1] = 0;
        for(int i=1;i<len;i++){
            leftSum[i] = nums[i-1] + leftSum[i-1];
            rightSum[len-i-1] = nums[len-i] + rightSum[len-i];
        }
        
        for(int i=0;i<len;i++){
            if(leftSum[i] == rightSum[i])
                return i;
        }
        return -1;
    }
}
/**
Space Complexiy -> O(N)
Time Complexity -> O(N)
*/
