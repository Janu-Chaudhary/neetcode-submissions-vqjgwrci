class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(new ArrayList<>(), nums, 0);
        return result;
        
    }
    public void subset (List<Integer>current, int[] nums, int index){
        // Add the result
        result.add(new ArrayList(current));

        for (int i = index; i < nums.length; i++){
            // Check for the unique solution
            if (i > index && nums[i] == nums[i-1]){
                continue;
            }

            // add the element
            current.add(nums[i]);

            // recurse
            subset (current,nums, i+1);

            // remove the element
            current.remove(current.size() - 1);
        }

    }
}
