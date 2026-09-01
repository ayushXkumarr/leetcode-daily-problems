class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left < right){
            int mid = left + (right - left)/2;

            if(check(piles,mid) <= h){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }

    long check(int[] piles , int mid){
        long sum =0;
        for(int i=0;i<piles.length;i++){
            sum += (piles[i] + mid - 1)/mid;
        }
        return sum;
    }
}