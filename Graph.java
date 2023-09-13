import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjacencyList = new HashMap<>();
    int[][] adjacencyMatrix;
    
    public Graph(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    
    }
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    public List<Integer> shortestPath(int start, int end, int[][] puzzle3) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        int[] distances = new int[puzzle3.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        boolean[] visited = new boolean[puzzle3.length];

        minHeap.offer(new Node(start, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            if (visited[currentNode.vertex]) {
                continue;
            }
            visited[currentNode.vertex] = true;

            for (Edge neighbor : adjacencyList.getOrDefault(currentNode.vertex, new ArrayList<>())) {
                if (!visited[neighbor.destination]) {
                    int newDistance = distances[currentNode.vertex] + neighbor.weight;
                    if (newDistance < distances[neighbor.destination]) {
                        distances[neighbor.destination] = newDistance;
                        minHeap.offer(new Node(neighbor.destination, newDistance));
                    }
                }
            }
        }

        List<Integer> shortestPath = new ArrayList<>();
        int current = end;
        while (current != start) {
            shortestPath.add(current);
            for (Edge edge : adjacencyList.get(current)) {
                if (distances[current] == distances[edge.destination] + edge.weight) {
                    current = edge.destination;
                    break;
                }
            }
        }
        shortestPath.add(start);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
