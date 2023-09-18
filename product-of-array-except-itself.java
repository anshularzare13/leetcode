class Solution {

  //Solution with O(n) time and O(1) space complexity.
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for(int i=1;i<len;i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
      
      int temp=1;
        for(int i=len-2;i>=0;i--){
            temp = temp*nums[i+1];
            answer[i] = answer[i]*temp;
        }

         return answer;
         //Can I do the same without using 2 additional arrays.

    }

   //Solution with O(n) time and O(n) space complexity.
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] prefixProduct = new int[len];
        int[] suffixProduct = new int[len];
        prefixProduct[0] = 1;
        suffixProduct[len-1]=1;
        for(int i=1;i<len;i++){
            prefixProduct[i] = prefixProduct[i-1]*nums[i-1];
        }

        for(int i=len-2;i>=0;i--){
            suffixProduct[i] = suffixProduct[i+1]*nums[i+1];
        }

        int[] answer = new int[len];
         for(int i=0;i<len;i++){
             answer[i] = prefixProduct[i] * suffixProduct[i];
         }
         return answer;
         //Can I do the same without using 2 additional arrays.
         
    }
}
