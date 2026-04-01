class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<HashMap<Character, Integer>> map = new ArrayList<>();
        HashSet<Integer> checked = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> hash = new HashMap<>();
            for (char c : strs[i].toCharArray()) {
                hash.put(c, hash.getOrDefault(c, 0) + 1);
            }
            map.add(hash);
        }

        for (int i = 0; i < strs.length; i++) {
            if (checked.contains(i)) continue;

            ArrayList<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            checked.add(i);

            for (int j = i + 1; j < strs.length; j++) {
                if (!checked.contains(j) && map.get(i).equals(map.get(j))) {
                    temp.add(strs[j]);
                    checked.add(j);
                }
            }

            res.add(temp);
        }
        return res;
    }
}
