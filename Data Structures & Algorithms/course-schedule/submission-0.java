class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites.length != numCourses - 1) return false; 
    if (numCourses == 0 || numCourses == 1) return true;

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
    for (int[] edge : prerequisites) {
        adj.get(edge[0]).add(edge[1]);
    }

    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    
    q.offer(0);
    visited.add(0);
    while (!q.isEmpty()) {
        int node = q.poll();
        for (int nei : adj.get(node)) {
            if (visited.contains(nei)) return false; 
            
            q.offer(nei);
            visited.add(nei);
        }
    }

    return visited.size() == numCourses;
    }
}

