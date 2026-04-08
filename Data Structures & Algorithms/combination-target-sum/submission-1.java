class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combination(new ArrayList<>(), nums, target, 0);
        return result;
        
    }

    public void combination (List<Integer> current, int[] nums, int remaining, int index){
        // result add condition
        if (remaining == 0){
            result.add(new ArrayList(current));
            return;
        }

        // termination condition
        if (remaining < 0){
            return ;
        }

        for (int i = index; i < nums.length; i++){

            // add the element
            current.add(nums[i]);

            // recurse --  As duplicates allowed do not increase index
            //  As we are tracking for target subtract the number we added from remaining;
            combination(current, nums, remaining-nums[i], i);

            current.remove(current.size()-1);
        }
    }
}
