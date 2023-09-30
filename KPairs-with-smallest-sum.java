class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<List<Integer>> result = new ArrayList<>();
      PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.sum));
      Pair p = new Pair(0,0, nums1[0]+nums2[0]);
      pq.offer(p);
      Set<Pair> visited = new HashSet<>();
      visited.add(p);
      // while(result.size() < k){ //nums1 = [1,7,11], nums2 = [2,4,6], k = 3
          //nums1 = [1,1,2] //Dry-run -> [0,0],[]
          //nums2 = [1,2,3]
          //k=10.
          while(pq.size() > 0){
              Pair top = pq.poll();
              List<Integer> ll = Arrays.asList(nums1[top.index1], nums2[top.index2]);
              result.add(ll);
              if(result.size() == k){
                  break;
              }
             
              if(top.index1 < nums1.length -1) {
                Pair p1 = new Pair(top.index1+1, top.index2, nums1[top.index1+1] + nums2[top.index2]);
                if(!visited.contains(p1)){
                    pq.offer(p1);
                    visited.add(p1);
                }
                    
              }

              if(top.index2 < nums2.length - 1){
                Pair p2 = new Pair(top.index1, top.index2+1, nums1[top.index1] + nums2[top.index2+1]);
                if(!visited.contains(p2)){
                    pq.offer(p2);
                    visited.add(p2);
                }
              }
          }
      // }

      return result;
    }

    class Pair{
      int index1;
      int index2;
      int sum;

      public Pair(int index1, int index2, int sum) {
          this.index1 = index1;
          this.index2 = index2;
          this.sum = sum;
      }


      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof Pair)) return false;
          Pair pair = (Pair) o;
          return index1 == pair.index1 && index2 == pair.index2;
      }

      @Override
      public int hashCode() {
          return Objects.hash(index1, index2);
      }
    }
}
