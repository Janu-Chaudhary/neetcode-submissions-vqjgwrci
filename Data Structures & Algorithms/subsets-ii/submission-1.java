class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            subSetII(new ArrayList<>(), nums, 0);
            return result;
    }

    public void subSetII (List<Integer> current, int[] nums, int index){
       
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i-1]){
                continue;
            }


            current.add(nums[i]);
            subSetII(current,nums, i+1);

            current.remove(current.size()-1);

        }

    }
}
