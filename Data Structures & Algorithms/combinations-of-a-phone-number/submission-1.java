class Solution {
     List<String> result = new ArrayList<>();
    
    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {

      if (digits.length() == 0){
        return result;
      }
      combination("", digits, 0);
      return result;
        
    }

    public void combination (String current, String digits, int index){
      if(current.length() == digits.length()){
        result.add(current);
        return ;
      }

      char number = digits.charAt(index);
      String letters = keypad[number -'0'];

      for (int i = 0; i < letters.length(); i++){
        combination(current + letters.charAt(i), digits, index + 1);
      }
    }
}
