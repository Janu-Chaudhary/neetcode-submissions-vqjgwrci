class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        int i = 0;
        int maxfreq = 0;
        int maxLen = 0;

        for(int j = 0; j < s.length(); j++){
            int characterIndex = s.charAt(j) - 'A';
            chars[characterIndex]++;

            maxfreq = Math.max(maxfreq, chars[characterIndex]);


            while((j-i+1) - maxfreq > k){
                chars[s.charAt(i) - 'A']--;
                i++;

                maxfreq = 0;
                for(int freq:chars){
                    maxfreq = Math.max(freq, maxfreq);
                }
            }

            maxLen = Math.max(maxLen, j-i+1);

        }

        return maxLen;
    }
}
