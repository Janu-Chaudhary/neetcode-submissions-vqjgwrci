
public class Solution {
    List<String> result = new ArrayList<>();
    
    // Index 0 and 1 are empty strings because 0 and 1 don't have letters.
    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        
        // Edge case: If the input is empty, return an empty list immediately.
        if (digits == null || digits.length() == 0) {
           return result;
        }
        
        backtrack(new StringBuilder(), digits, 0);
        return result;
    }

    public void backtrack(StringBuilder current, String digits, int index) {
        // Base Condition: 
        // If our built string is the same length as the input digits, we are done.
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digitChar = digits.charAt(index);
        
        int digit = digitChar - '0';
        
        String letters = keypad[digit];

        // THE TWIST: Loop through the letters of the CURRENT digit, not the input array!
        for (int i = 0; i < letters.length(); i++) {
            // Choose the letter
            current.append(letters.charAt(i));
            
            // Recurse: We use 'index + 1' here to tell the next call: 
            // "I picked a letter for the current digit, now move to the NEXT digit."
            backtrack(current, digits, index + 1);
            
            // Backtrack: Remove the last letter we added so we can try the next one
            current.deleteCharAt(current.length() - 1);
        }
    }

}