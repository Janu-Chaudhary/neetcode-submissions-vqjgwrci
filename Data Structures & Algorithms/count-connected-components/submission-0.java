class Solution {
    public int countComponents(int n, int[][] edges) {
        // 1. Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        // 2. Iterate through each node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++; // Found a new component
                dfs(adj, visited, i); // Mark all nodes in this component
            }
        }

        return components;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int index) {
        visited[index] = true;
        for (int neighbor : adj.get(index)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }
}