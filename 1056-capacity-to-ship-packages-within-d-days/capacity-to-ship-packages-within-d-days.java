class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            left = Math.max(left,weights[i]);
            sum += weights[i];
        }

        int right = sum;

        while(left < right){
            int mid = left + (right - left)/2;

            if(check(weights,mid) <= days){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }


    long check (int [] arr,int mid){
        int day =1;
        int wt =0;

        for(int i=0;i<arr.length;i++){
            if(wt + arr[i] <= mid){
                wt += arr[i];
            }
            else{
                day++;
                wt =arr[i];
            }
        }

        return day;
    }
}