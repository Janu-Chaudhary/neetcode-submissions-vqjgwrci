class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            hash.add(nums[i]);}

        if (nums.length == hash.size()){
            return false;
        } 

        return true;
        }
    
}