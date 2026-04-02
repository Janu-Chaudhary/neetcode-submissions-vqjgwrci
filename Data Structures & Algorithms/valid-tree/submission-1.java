public class Solution {
 public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false; 
    if (n == 0 || n == 1) return true;

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    Map<Integer, Integer> parent = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    
    q.offer(0);
    parent.put(0, -1);
    while (!q.isEmpty()) {
        int node = q.poll();2
        for (int nei : adj.get(node)) {
            if (parent.get(node) == nei) continue; 
            if (parent.containsKey(nei)) return false; 
            
            q.offer(nei);
            parent.put(nei, node);
        }
    }

    return parent.size() == n;
}

}