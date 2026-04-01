class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> res = new ArrayList<>();
    //     ArrayList<Integer> checked = new ArrayList<>();

    //     for (int i = 0; i < strs.length; i++) {
    //         if (checked.contains(i)) continue;

    //         List<String> group = new ArrayList<>();
    //         group.add(strs[i]);
    //         checked.add(i);

    //         HashMap<Character, Integer> hash = new HashMap<>();
    //         for (char c : strs[i].toCharArray()) {
    //             hash.put(c, hash.getOrDefault(c, 0) + 1);
    //         }

    //         for (int j = i + 1; j < strs.length; j++) {
    //             if (checked.contains(j)) continue;

    //             HashMap<Character, Integer> hash_j = new HashMap<>();
    //             for (char c : strs[j].toCharArray()) {
    //                 hash_j.put(c, hash_j.getOrDefault(c, 0) + 1);
    //             }

    //             if (hash.equals(hash_j)) {
    //                 group.add(strs[j]);
    //                 checked.add(j);
    //             }
    //         }
    //         res.add(group);
    //     }
    //     return res;
    // }


        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray); 
            List<String> list = map.getOrDefault(sortedKey, new ArrayList<>());
            list.add(s);
            map.put(sortedKey, list);


            
        }

        return new ArrayList<>(map.values());
    }
}



