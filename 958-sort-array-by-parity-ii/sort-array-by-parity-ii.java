class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int j = 1;

        for (int i = 0; i < nums.length; i += 2) {

            // Even index already has an even number
            if (nums[i] % 2 == 0) {
                continue;
            }

            // Find an even number at an odd index
            while (nums[j] % 2 == 1) {
                j += 2;
            }

            // Swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}