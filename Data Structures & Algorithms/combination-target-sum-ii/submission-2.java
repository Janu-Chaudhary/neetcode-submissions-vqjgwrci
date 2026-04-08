class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // remember to sort first for unique cases
        Arrays.sort(candidates);
        combination(new ArrayList<>(), candidates, target, 0);
        return result;
        
    }

    // carefull for recursive call i

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
            // As unique combinations are only allowed 
            if (i > index && nums[i] == nums[i-1]){
                continue;
            }

            // add the element
            current.add(nums[i]);

            //  As we are tracking for target subtract the number we added from remaining;
            combination(current, nums, remaining-nums[i], i+1);

            current.remove(current.size()-1);
        }
    }
}
