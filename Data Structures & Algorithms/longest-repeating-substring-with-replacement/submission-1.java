class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int i = 0;
        int maxFreq = 0; 
        int maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            int currentCharIndex = s.charAt(j) - 'A';
            counts[currentCharIndex]++;
            
            maxFreq = Math.max(maxFreq, counts[currentCharIndex]);

            while ((j - i + 1) - maxFreq > k) {
                counts[s.charAt(i) - 'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
