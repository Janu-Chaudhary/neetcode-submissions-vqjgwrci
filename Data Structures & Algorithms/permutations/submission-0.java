class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Boolean> numUsed = new ArrayList<>(Collections.nCopies(nums.length, false));
        powerset(new ArrayList<>(), nums, numUsed, 0); 
        return result;
    }

    public void powerset(List<Integer> current, int[] nums, List<Boolean> numUsed, int index) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index == nums.length) {
            return;
        }

        if (numUsed.get(index) == false) {
            current.add(nums[index]);
            numUsed.set(index, true);
            
            powerset(current, nums, numUsed, 0);
            
            current.remove(current.size() - 1);
            numUsed.set(index, false);
        }

        powerset(current, nums, numUsed, index + 1);        
    }
}