class Solution {

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        parenthesis(new String(), 0, 0, n);
        return result;
        
    }

    public void parenthesis(String current, int open, int close, int n){

        if(current.length() == 2*n && open == n && close == n){
            result.add(current);
            return ;
        }else if (current.length() >= 2*n){
            return;
        }

        // Pair
        if (open < n){
        parenthesis(current+"(", open+1, close, n);
        }
        // close
        if (close < open){
        parenthesis(current+")", open, close+1, n);
        }

    }
}
