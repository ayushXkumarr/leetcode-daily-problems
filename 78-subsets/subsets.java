class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(nums, 0, path, ans);

        return ans;
    }

    void backtrack(int[] nums, int index,
                   List<Integer> path,
                   List<List<Integer>> ans) {

        // Base case
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // TAKE
        path.add(nums[index]);

        backtrack(nums, index + 1, path, ans);

        // UNDO
        path.remove(path.size() - 1);

        // DON'T TAKE
        backtrack(nums, index + 1, path, ans);
    }
}