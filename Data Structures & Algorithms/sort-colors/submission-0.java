class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int current = 0;

        // Change: Must stop at 'two' to avoid re-swapping sorted elements
        while (current <= two) {
            int number = nums[current];

            if (number == 0) {
                int temp = nums[current];
                nums[current] = nums[zero];
                nums[zero] = temp;
                current++;
                zero++;
            } else if (number == 2) {
                // Fixed your swap logic here as well
                int temp = nums[current];
                nums[current] = nums[two];
                nums[two] = temp;
                two--; 
                // Note: current does NOT increment here
            } else {
                current++;
            }
        }
    }
}
