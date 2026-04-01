class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> st = new HashSet<>();

        while (j < s.length()){
            if (st.contains(s.charAt(j))){
                while(s.charAt(i) != s.charAt(j)){
                    st.remove(s.charAt(i));
                    i += 1;
                }
                i += 1;
            }
                max = Math.max((j-i+1),max);
                st.add(s.charAt(j));
                j+=1;
        }
        return max;

    }
}
