class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; 
        
        int product  = 1;
        int zerocount = 0;

        for (int num:nums){
            if(num == 0){
                zerocount++;
            }else{
                product *= num;
            }
        }

        for (int i = 0; i < n; i++){
            if (zerocount > 1){
                res[i] = 0;
            }else if(zerocount == 1 ){
                if (nums[i] == 0){
                    res[i] = product;
                }else{
                    res[i] = 0;
                }
            }else{
                res[i] = product/nums[i];
            }
        }

        return res;

    }
}

