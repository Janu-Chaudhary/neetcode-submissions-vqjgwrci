class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        powerset(new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void powerset(List<Integer> current, int[] nums, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == nums.length) {
            return;
        }

        current.add(nums[index]);
        powerset(current, nums, index + 1, target - nums[index]);
        current.remove(current.size() - 1); 

        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        powerset(current, nums, index + 1, target);
    }
}
