class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1;
        int right = position[position.length -1] - position[0];

        while(left < right){
            int mid = left + (right - left + 1 )/2;

            if(check(position,mid) >= m){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }

    long check ( int[] arr,int mid){
        int ball=1;
        int distance = arr[0];

        for(int i=0;i<arr.length;i++){
            if((arr[i] - distance) >= mid){
                ball++;
                distance =arr[i];
            }
        }

        return ball;
    }
}