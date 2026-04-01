class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] result = {0,0};

        while (i < j){
            if((numbers[i] + numbers[j]) == target){
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
            if ((numbers[i]+numbers[j] > target)){
                j -= 1;
                continue;
            }
            if((numbers[i] + numbers[j])<target){
                i += 1;
            }
       
        }
        
        return result;
    }
}
