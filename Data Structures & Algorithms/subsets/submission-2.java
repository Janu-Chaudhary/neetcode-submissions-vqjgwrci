class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(new ArrayList<>(), nums, 0);
        return result;
        
    }

    public void subset (List<Integer> current, int[] nums, int index){
        // Add the result
        result.add(new ArrayList(current));

        // Start building the current array by fill the elements from index  = index of nums
        for (int i = index; i < nums.length; i++){  // Here i represents we adding the ith element

            // Add the element into current
            current.add(nums[i]);

            // Recurse for next index filling with current array
            subset (current, nums, i + 1); // here we are recursing for the next element filling

            // Now we are removing the element from index = index, so we can fill index with different element
            current.remove(current.size()-1);
        }

    }
}
