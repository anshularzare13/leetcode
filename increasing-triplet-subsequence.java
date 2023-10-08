public boolean increasingTriplet(int[] nums) {
        /** 
        Idea is to maintain two integers. 
        firstMin -> represents the first minimum number of the solution.
        secondMin -> represents the second minimum number of the solution & secondmin > firstMin.
        
        Algo:
        1. If i find an element greater than  secondMin, then i have found the triplet & returns true.
        2. If i find an element greater than firstMin but less secondMin, then this is new secondmin. firstMin remains unchanged.
        3. If i find an element less than firstMin, then this is my new firstMin. At this point i have not updated secondMin, so I may feel that firstMin is after secondMin in the array and it breaks the index constraint. but i am not only returning true if i find number greater than secondMin & secondMin > firstMin.
        This operation makes us consider next smallest secondMin greater than firstMin.
        */
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num:nums){
            if(num > secondMin){
                return true;
            }else if(num > firstMin){
                secondMin = num;
            }else{
                firstMin = num;
            }
        }
      return false;
}
