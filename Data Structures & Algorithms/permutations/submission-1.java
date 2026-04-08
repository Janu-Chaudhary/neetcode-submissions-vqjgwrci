
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        // Use a simple boolean array. It defaults to false automatically.
        boolean[] used = new boolean[nums.length]; 
        
        permutation(new ArrayList<>(), nums, used); 
        return result;
    }

    public void permutation(List<Integer> current, int[] nums, boolean[] used) {

        // Add the result when its length equals nums length
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // CRITICAL DIFFERENCE: Always start from i = 0!
        // We want to evaluate every single number, every single time, 
        // to get all possible orderings.
        for (int i = 0; i < nums.length; i++) {
            
            // We only pick this number if it isn't already sitting in 'current'
            if (used[i] == false) {
                
                // use the element in current building
                current.add(nums[i]);
                // mark the element as used
                used[i] = true;

                // recurse for next element (still no index passed)
                permutation(current, nums, used);

                // backtrack: unmark the element so other branches can use it
                used[i] = false;
                // remove the element from current
                current.remove(current.size() - 1);
            }
        }
    }
}