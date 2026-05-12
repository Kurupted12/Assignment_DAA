package Question_03;

import java.util.LinkedList;
import java.util.Stack;


public class TopologicalSort {

        private int vertices;
        private LinkedList<Integer>[] graph;


        TopologicalSort(int v) {

            vertices = v;

            graph = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                graph[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int destination) {
            graph[source].add(destination);
        }


        void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {

            visited[vertex] = true;

            for (int neighbour : graph[vertex]) {

                if (!visited[neighbour]) {
                    dfs(neighbour, visited, stack);
                }
            }

            stack.push(vertex);
        }


        void topologicalSort() {

            Stack<Integer> stack = new Stack<>();

            boolean[] visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {

                if (!visited[i]) {
                    dfs(i, visited, stack);
                }
            }

            System.out.println("Topological Sort Order:\n");

            while (!stack.empty()) {
                System.out.print(stack.pop() + " ");
            }
        }

        public static void main(String[] args) {

            TopologicalSort graph = new TopologicalSort(6);

            // Example graph
            graph.addEdge(5, 2);
            graph.addEdge(5, 0);
            graph.addEdge(4, 0);
            graph.addEdge(4, 1);
            graph.addEdge(2, 3);
            graph.addEdge(3, 1);

            graph.topologicalSort();
        }


}
