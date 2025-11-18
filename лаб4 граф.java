Реализация графа на Java
  
java
import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjacencyList;
    
    class Edge {
        String destination;
        int weight;
        
        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    class Node implements Comparable<Node> {
        String name;
        int distance;
        
        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    public Graph() {
        adjacencyList = new HashMap<>();
    }
    
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>())
                    .add(new Edge(destination, weight));
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>())
                    .add(new Edge(source, weight));
    }
    
    public Map<String, Integer> dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        priorityQueue.add(new Node(start, 0));
        
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            
            if (current.distance > distances.get(current.name)) {
                continue;
            }
            
            for (Edge edge : adjacencyList.get(current.name)) {
                int newDistance = current.distance + edge.weight;
                
                if (newDistance < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDistance);
                    priorityQueue.add(new Node(edge.destination, newDistance));
                }
            }
        }
        
        return distances;
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);
        
        Map<String, Integer> distances = graph.dijkstra("A");
        
        System.out.println("Кратчайшие расстояния от вершины A:");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("До " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
