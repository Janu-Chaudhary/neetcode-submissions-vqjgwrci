class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max = 0;
        while(i < j){
            int water;

            water = Math.min(heights[i],heights[j])*(j-i);
            max = Math.max(water,max);

            if (heights[i] > heights[j]){
                j -= 1;
            }else if(heights[i] < heights[j]){
                i += 1;
            }else{
                i+=1;
            }

        }
        return max;
    }
}
