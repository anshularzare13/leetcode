class Solution {
    public int firstMissingPositive(int[] nums) {
        //We need to find the first missing positive number.
        //so,  I can deduce the following.
        //if length of array is n, then first missing positive number would be in the range of 1..n+1.
        //because if the array contains numbers from 1..n then answer would be n+1.
        //If array contains any number < 1 or > n or repeating any number, then it is occupying the place of any number from 1..n.

        //so with this deduction we have to place each number at index number-1.
        //how ?? by swap.
        //after doing that, we will check for an index whose value is not equal to index+1. If no such element is found then return n+1.
        int len = nums.length;
        for(int i=0;i<len;){
            if(nums[i] >=1 && nums[i] <= len){
                int index = nums[i]-1;
                if(index != i && nums[i]!=nums[index]){
                    int tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = tmp;
                }
                else{
                    i++;
                }
            }else{
                i++;
            }
        //    print(i, nums);
        }

        for(int i=0;i<len;i++){
            if(nums[i]!=i+1)
                return i+1;
         }
         return len+1;

    }

    private void print(int x, int[] nums){
            for(int i=0;i<nums.length;i++){
                System.out.print(nums[i] +" ");
            }
            System.out.println();
    }
}
