class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1 ){
            return false;

        }

        Set<Integer> visited = new HashSet<>();

        for (int[] edge: edges){
            if (visited.contains(edge[1])){
                return false;
            }else{
                visited.add(edge[0]);
                visited.add(edge[1]);
            }
        }

        return true;
    }
}
