class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){return 0;}
        int max = 0;
        for (int i = 0; i <s.length(); i++){
            Set<Character> st = new HashSet<>();
            for(int j = i; j<s.length();j++){
                char c = s.charAt(j);
                if (st.contains(c)){
                    break;
                }
                st.add(c);
                max = Math.max(max,st.size());

            }
        }
      return max;
    }
}
