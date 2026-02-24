package Graphs;

import java.util.*;

public class Graph {

    private int V; // Number of vertices
    private LinkedList<Integer>[] adjacencyList;  // array of LL
    public Graph(int vertices) {
        V = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
    }
    }

    public  void addEdge(int vertex1, int vertex2){
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
    }

    public void addVertex() {
        // Create a new vertex
        int newVertex = V;
        V++;

        // Create a new adjacency list with the updated size
        LinkedList<Integer>[] newAdjacencyList = new LinkedList[V];

        // Copy the existing adjacency lists into the new array
        for (int i = 0; i < V - 1; i++) {
            newAdjacencyList[i] = adjacencyList[i];
        }

        // Add an empty adjacency list for the new vertex
        newAdjacencyList[newVertex] = new LinkedList<>();

        // Update the adjacency list reference
        adjacencyList = newAdjacencyList;
    }

    public void removeEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].remove(Integer.valueOf(vertex2));
        adjacencyList[vertex2].remove(Integer.valueOf(vertex1));
    }

    public void removeVertex(int vertex) {
        adjacencyList[vertex].clear(); // Remove all edges connected to the vertex
        for (LinkedList<Integer> list : adjacencyList) {
            list.remove(Integer.valueOf(vertex)); // Remove references to the vertex from other adjacency lists
        }
    }

    public void printAdjacencyList() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Integer neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public boolean hasPath(int vertex1, int vertex2) {
        // Create a new array to keep track of visited vertices for this specific search
        boolean[] visited = new boolean[V];

        // Call the helper method to perform DFS from vertex1
        return hasPathDFS(vertex1, vertex2, visited);
    }

    private boolean hasPathDFS(int currentVertex, int targetVertex, boolean[] visited) {
        // Mark the current vertex as visited
        visited[currentVertex] = true;

        // If the current vertex is the target vertex, a path exists
        if (currentVertex == targetVertex) {
            return true;
        }

        // Recursively visit all adjacent vertices
        for (int neighbor : adjacencyList[currentVertex]) {
            if (!visited[neighbor] && hasPathDFS(neighbor, targetVertex, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Graph graph = new Graph(5);

        // Add some edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printAdjacencyList();
        // Add a new vertex and print the updated adjacency list
        graph.addVertex();
        graph.addEdge(5, 1);
        // System.out.println("After adding a new vertex:");
        // graph.printAdjacencyList();

        // Remove an edge and print the updated adjacency list
        graph.removeEdge(0, 1);
        // System.out.println("After removing an edge (0-1):");
        // graph.printAdjacencyList();

        // Remove a vertex and print the updated adjacency list
        graph.removeVertex(3);
        // System.out.println("After removing vertex 3:");
        // graph.printAdjacencyList();


        System.out.println(graph.hasPath(1,0));
    }
}
