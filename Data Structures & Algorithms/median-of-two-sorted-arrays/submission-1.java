class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;
        
        int p1 = 0;
        int p2 = 0;
        int current = 0;
        int last = 0;

        for (int i = 0; i <= total / 2; i++) {
            last = current;
            if (p1 < n && (p2 >= m || nums1[p1] < nums2[p2])) {
                current = nums1[p1];
                p1 += 1;
            } else {
                current = nums2[p2];
                p2 += 1;
            }
        }

        if (total % 2 == 0) {
            return (double) (last + current) / 2.0;
        } else {
            return (double) current;
        }
    }
}
