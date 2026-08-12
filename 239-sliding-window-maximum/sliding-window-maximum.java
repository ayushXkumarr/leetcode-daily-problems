class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        // First window: 0 to k-1
        for (int i = 0; i < k; i++) {

            // Remove smaller elements from back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        // Maximum of first window
        ans[index++] = nums[dq.peekFirst()];

        // Remaining windows
        for (int right = k; right < n; right++) {

            int left = right - k;

            // Remove expired indices from front
            while (!dq.isEmpty() &&
                   dq.peekFirst() <= left) {
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[right]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(right);

            // Front always has maximum
            ans[index++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}