//https://leetcode.com/problems/dota2-senate
class Solution {
    public String predictPartyVictory(String senate) {
       
        char[] sArray = senate.toCharArray();
        int n = sArray.length;
        //maintain two queue holding the index of each senate.
        Queue<Integer> rq = new LinkedList();
        Queue<Integer> dq = new LinkedList();
        for(int i=0;i<sArray.length;i++){
            if(sArray[i] == 'R'){
                rq.offer(i);
            }else{
                dq.offer(i);
            }
        }

        //Now remove compare top element of both queues, until one of them is empty.
        //the one with lesser index will win and will be placed at the each of the queue.
        while(rq.size() > 0 && dq.size() > 0){
            int rIndex = rq.poll();
            int qIndex = dq.poll();

            if(rIndex < qIndex){
                rq.offer(rIndex + n);
            }else{
                dq.offer(qIndex + n);
            }
        }

        if(rq.size() > 0){
            return "Radiant";
        }
        return "Dire";
    }
}
