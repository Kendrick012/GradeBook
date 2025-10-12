import java.util.*;

class P1 {
    public static void dijkstra(Map<Integer, List<int[]>> graph, int start, int goal) {
        // Priority queue to hold pairs (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, start});  // (distance, node)
        
        // Map to store the shortest distance to each node
        Map<Integer, Integer> dist = new HashMap<>();
        for (Integer node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);  // Initialize distances to infinity
        }
        dist.put(start, 0);  // Distance to start is 0
        
        // Main Dijkstra loop
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int node = current[1];
            
            // If we reached the goal, print the result and return
            if (node == goal) {
                System.out.println("Shortest distance from " + start + " to " + goal + ": " + currentDist);
                return;
            }
            
            // Explore neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    int newDist = currentDist + weight;
                    
                    // If a shorter path is found
                    if (newDist < dist.get(nextNode)) {
                        dist.put(nextNode, newDist);
                        pq.add(new int[]{newDist, nextNode});
                    }
                }
            }
        }
        System.out.println("No path found from " + start + " to " + goal);
    }

    public static void main(String[] args) {
        // Create the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new int[]{2, 7}, new int[]{3, 9}, new int[]{6, 14}));
        graph.put(2, Arrays.asList(new int[]{1, 7}, new int[]{3, 10}, new int[]{4, 15}));
        graph.put(3, Arrays.asList(new int[]{1, 9}, new int[]{2, 10}, new int[]{6, 2}, new int[]{4, 11}));
        graph.put(4, Arrays.asList(new int[]{2, 15}, new int[]{3, 11}, new int[]{5, 6}));
        graph.put(5, Arrays.asList(new int[]{4, 6}, new int[]{6, 9}));
        graph.put(6, Arrays.asList(new int[]{1, 14}, new int[]{3, 2}, new int[]{5, 9}));
        
        // Run Dijkstra's algorithm
        dijkstra(graph, 1, 5);
    }
}
