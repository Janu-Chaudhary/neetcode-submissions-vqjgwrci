class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            adj.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);
            count++;

            for (int neigh : adj.get(node)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        if (count != numCourses) {
            return new int[0];
        }

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}