class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        // Build the graph and count indegrees
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        // Start with courses that have NO prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++; // "Take" the course

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--; // One prerequisite satisfied
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // If we "took" all courses, there was no cycle
        return count == numCourses;
    }
}