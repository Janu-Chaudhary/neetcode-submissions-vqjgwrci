class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            subSetII(new ArrayList<>(), nums, 0);
            return result;
    }

    public void subSetII (List<Integer> current, int[] nums, int index){
        if (index == nums.length){
            result.add(new ArrayList<>(current));
            return ;
        }

        current.add(nums[index]);
        subSetII(current,nums, index+1);

        current.remove(current.size()-1);

        while(index < nums.length-1 && nums[index] == nums[index+1]){
            index += 1;
        }

        subSetII(current, nums, index+1);
    }
}
