class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(new ArrayList<>(), nums, 0, target);
        return result;
    }

    private void backtrack(List<Integer> current, int[] nums, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == nums.length) {
            return;
        }

        current.add(nums[index]);
        backtrack(current, nums, index, target - nums[index]);

        current.remove(current.size() - 1); 
        backtrack(current, nums, index + 1, target);
    }
}
