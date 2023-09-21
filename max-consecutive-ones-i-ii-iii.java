class Solution {

    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int max = 0;
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                zeros++;
            }

            while(zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }  
                left++;
            }
            right++;
            max=Math.max(right-left, max);
            
        }
        return Math.max(right-left, max);
    
    }

    public int longestOnes1(int[] nums, int k) {
         int zeros = 0;
         int max = 0;
        for(int left=0;left<nums.length;left++){
            for(int right = left;right<nums.length;right++){
                    if(nums[right] == 0){
                        zeros++;
                    }
                    if(zeros <= k){
                        max = Math.max(right- left+1, max);
                    }else{
                        zeros= 0;
                        break;
                    }
                }
        }
        return max;
     }
     

    public int longestOnes2(int[] nums, int k) {
        //Assuming k = 1
        int start=0, end=0, max=0, fi = 0;
        boolean flipped = false;
        for(int i=0;i<nums.length;i++){
            
            if(!flipped){
                if(nums[i] == 1 && start == -1){
                    start = i;
                    end = i;
                }else if(nums[i] == 1){
                    end = i;
                }else if(nums[i] == 0 && start == -1){
                    start = i;
                    flipped = true;
                }else{
                    end = i;
                    flipped = true;
                    fi = i;
                }
            }else{
                if(nums[i] == 1){
                    end = i;
                }else{
                    max = Math.max(end-start+1, max);
                    start = fi + 1;
                    end = i;
                    fi = i;
                }
            }
        }

        max = Math.max(end-start+1, max);
        return max;

    }


      public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, maxOnes = 0;
        for(int num: nums){
            ones+=num;
            if(num==0){
                if(ones > maxOnes)
                   maxOnes = ones;
                ones = 0;
            }
        }
        return Math.max(ones, maxOnes);
    }
}
