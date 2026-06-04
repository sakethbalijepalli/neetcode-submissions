class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      //        To eat 1 banana koko takes 1 hour - min rate
//        To eat x bananas koko takes ceil(x / k) hours where k is the eating rate
//        Upper bound for K is max bananas from piles
//        range is from 1 to max(piles)
// .      25 10 23 4 and h = 4  we pick the max because otherwise we wouldnt be able to finish the bananas from all the piles within
//        the given time
//        if max < h then we go for picking the min rate i.e 1
//        questions is how can we apply binary search here
        int high = Integer.MIN_VALUE;
        for(int n : piles){
            high = Math.max(high,n);
        }
        int left = 1;
        int mid = 0;
        int result = 1;
        while (left <= high){
            mid = left + (high - left) / 2;
            long kokosRate = 0;
            for (int pile : piles) {
                 kokosRate = kokosRate + (long) Math.ceil((double) pile / mid); // Here Kokos eating rate will take 62 hours where i is 1
            }
            if (kokosRate > h) {
                left = mid + 1;
            }else {
                high = mid - 1;
                result = mid;
            }
        }
        return result;

    }
}
