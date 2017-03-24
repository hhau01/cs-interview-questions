/*
    Simple implementation of Depth First Search & Breathe First Search

    DFS - recursively traverse down the graph making sure to mark visited nodes until you find the node you are looking for

    BFS - iteratively search through each node and its children by using a queue until you find the node you are looking for
*/

import java.util.LinkedList;

public class GraphSearch {
    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();
        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);

        if (source.equals(destination)) {
            return true;
        }

        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    public boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);

        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();

            if (node.equals(destination)) {
                return true;
            }

            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);

            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}