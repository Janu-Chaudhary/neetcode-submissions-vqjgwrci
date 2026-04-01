class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums[0];

        while (low <= high){
           int  mid = low + (high - low)/2;

            if (nums[low] <= nums[high]) {
                res = Math.min(res, nums[low]);
            }

            if (nums[mid] >= nums[low]){
                low = mid + 1;

            } else {
                res = Math.min(res, nums[mid]);
                high = mid - 1;
            }
        }
        return res;
        
    }
}