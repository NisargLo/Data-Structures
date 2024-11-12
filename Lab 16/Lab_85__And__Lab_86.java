/*
	Lab 85:-
	Write a program to create a graph & implement the adjacency list representation of the graph
	Apply DFS and BFS on the given graph.
	
	Lab 86:-
	Write a program to apply DFS & BFS for a graph.
 */

import java.util.*;

public class Lab_85__And__Lab_86 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		String node1, node2, oldNode, newNode;
		Int_Graph graph = new Int_Graph();
		while (true) {
			System.out.println("\nEnter 1 for insertNode():");
			System.out.println("Enter 2 for insertEdge():");
			System.out.println("Enter 3 for updateNode():");
			System.out.println("Enter 4 for deleteNode():");
			System.out.println("Enter 5 for deleteEdge():");
			System.out.println("Enter 6 for printGraph():");
			System.out.println("Enter 7 for DFS (Depth-First Search):");
			System.out.println("Enter 8 for BFS (Breadth-First Search):");
			System.out.println("Enter -1 to exit:");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					System.out.println("Enter Node name:");
					node1 = sc.nextLine();
					graph.insertNode(node1);
					break;
				
				case 2:
					System.out.println("Enter the first node:");
					node1 = sc.nextLine();
					System.out.println("Enter the second node:");
					node2 = sc.nextLine();
					graph.insertEdge(node1, node2);
					break;
				
				case 3:
					System.out.println("Enter the node name to update:");
					oldNode = sc.nextLine();
					System.out.println("Enter the new node name:");
					newNode = sc.nextLine();
					graph.updateNode(oldNode, newNode);
					break;
				
				case 4:
					System.out.println("Enter the node name to delete:");
					node1 = sc.nextLine();
					graph.deleteNode(node1);
					break;
				
				case 5:
					System.out.println("Enter the first node:");
					node1 = sc.nextLine();
					System.out.println("Enter the second node:");
					node2 = sc.nextLine();
					graph.deleteEdge(node1, node2);
					break;
				
				case 6:
					graph.printGraph();
					break;
				
				case 7:
					System.out.println("Enter the starting node for DFS:");
					node1 = sc.nextLine();
					graph.DFS(node1);
					break;
				
				case 8:
					System.out.println("Enter the starting node for BFS:");
					node1 = sc.nextLine();
					graph.BFS(node1);
					break;
				
				case -1:
					System.out.println("Program Over...");
					sc.close();
					return;
				
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

class Int_Graph {
	private final Map<String, List<String>> adjacencyList;
	
	public Int_Graph() {
		adjacencyList = new HashMap<>();
	}
	
	public void insertNode(String node) {
		if (!adjacencyList.containsKey(node)) {
			adjacencyList.put(node, new ArrayList<>());
			System.out.println("Node " + node + " inserted.");
		} else {
			System.out.println("Node " + node + " already exists.");
		}
	}
	
	public void insertEdge(String node1, String node2) {
		if (!adjacencyList.containsKey(node1) || !adjacencyList.containsKey(node2)) {
			System.out.println("Both nodes must exist in the graph.");
			return;
		}
		adjacencyList.get(node1).add(node2);
		adjacencyList.get(node2).add(node1);
		System.out.println("Edge inserted between " + node1 + " and " + node2);
	}
	
	public void updateNode(String oldName, String newName) {
		if (!adjacencyList.containsKey(oldName)) {
			System.out.println("Node " + oldName + " does not exist.");
			return;
		}
		
		List<String> neighbors = adjacencyList.remove(oldName);
		adjacencyList.put(newName, neighbors);
		
		for (String node : adjacencyList.keySet()) {
			List<String> edges = adjacencyList.get(node);
			for (int i = 0; i < edges.size(); i++) {
				if (edges.get(i).equals(oldName)) {
					edges.set(i, newName);
				}
			}
		}
		System.out.println("Node " + oldName + " updated to " + newName);
	}
	
	public void deleteNode(String node) {
		if (!adjacencyList.containsKey(node)) {
			System.out.println("Node " + node + " does not exist.");
			return;
		}
		
		for (String neighbor : adjacencyList.get(node)) {
			adjacencyList.get(neighbor).remove(node);
		}
		
		adjacencyList.remove(node);
		System.out.println("Node " + node + " and its edges deleted.");
	}
	
	public void deleteEdge(String node1, String node2) {
		if (!adjacencyList.containsKey(node1) || !adjacencyList.containsKey(node2)) {
			System.out.println("One or both nodes do not exist.");
			return;
		}
		adjacencyList.get(node1).remove(node2);
		adjacencyList.get(node2).remove(node1);
		System.out.println("Edge between " + node1 + " and " + node2 + " deleted.");
	}
	
	public void printGraph() {
		if (adjacencyList.isEmpty()) {
			System.out.println("The graph is empty.");
			return;
		}
		System.out.println("Graph representation (Adjacency List):");
		for (String node : adjacencyList.keySet()) {
			System.out.println(node + ": " + adjacencyList.get(node));
		}
	}
	
	public void DFS(String startNode) {
		if (!adjacencyList.containsKey(startNode)) {
			System.out.println("Node " + startNode + " not found.");
			return;
		}
		
		Set<String> visited = new HashSet<>();
		Stack<String> stack = new Stack<>();
		stack.push(startNode);
		visited.add(startNode);
		
		System.out.println("DFS (using stack) starting from node " + startNode + ":");
		while (!stack.isEmpty()) {
			String node = stack.pop();
			System.out.print(node + "  ");
			for (String neighbor : adjacencyList.get(node)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					stack.push(neighbor);
				}
			}
		}
		System.out.println();
	}
	
	public void BFS(String startNode) {
		if (!adjacencyList.containsKey(startNode)) {
			System.out.println("Node " + startNode + " not found.");
			return;
		}
		
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		visited.add(startNode);
		queue.add(startNode);
		
		System.out.println("BFS starting from node " + startNode + ":");
		while (!queue.isEmpty()) {
			String node = queue.poll();
			System.out.print(node + "  ");
			for (String neighbor : adjacencyList.get(node)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
		System.out.println();
	}
}
