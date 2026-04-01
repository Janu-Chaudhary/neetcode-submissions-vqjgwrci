class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        powerset(new ArrayList<>(), nums, 0);
        return result;
        
    }

    public void powerset (List<Integer> current, int[] nums, int index){
        if (index == nums.length){
            result.add(new ArrayList<>(current));
            return ;
        }

        current.add(nums[index]);
        powerset(current, nums, index+1);

        current.remove(current.size() - 1);
        powerset(current, nums, index+1);
    }



}
