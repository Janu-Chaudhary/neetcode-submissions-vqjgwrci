class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}
        
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }

        int res = 0;
        for (int num : hash) {
            if (!hash.contains(num - 1)) {
                int currNum = num;
                int currSeq = 1;

                while (hash.contains(currNum + 1)) {
                    currNum++;
                    currSeq++;
                }
                
                res = Math.max(res, currSeq);
            }
        }
        return res;
    }
}
