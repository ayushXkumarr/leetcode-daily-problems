class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(bloomDay, mid, k) >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    long check(int [] arr, int mid , int k){
        int consecutive = 0;
        int bouquets = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= mid){
                consecutive ++;
                if(consecutive == k){
                    bouquets ++;
                    consecutive =0;
                }
            }else{
                consecutive = 0;
            }

            
        }
        return bouquets;
        
    }
}