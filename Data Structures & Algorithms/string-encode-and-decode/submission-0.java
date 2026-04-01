
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()+"*"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) { 
            int k = str.indexOf('*', i);
            
            int len = Integer.parseInt(str.substring(i, k));
            
            int start = k + 1;
            res.add(str.substring(start, start + len)); 
            
            i = start + len;
        }
        return res;
    }
}
