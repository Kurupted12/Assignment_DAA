package Assignment_2;

import java.util.*;

public class Question_3 {

    static final int V = 8;

    int minDistance(int dist[], boolean spt[]) {

        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < V; i++) {

            if (!spt[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }

        return index;
    }

    void dijkstra(int graph[][], int src) {

        int[] dist = new int[V];
        int[] parent = new int[V];
        boolean[] spt = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        parent[src] = -1;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, spt);

            if (u == -1)
                break;

            spt[u] = true;

            for (int v = 0; v < V; v++) {

                if (!spt[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Vertex\tDistance\tParent");

        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i] + "\t\t" + parent[i]);
        }
    }

    public static void main(String[] args) {

        int[][] graph = {

                {0,4,0,0,0,0,0,8},
                {4,0,8,0,0,0,11,0},
                {0,8,0,7,0,4,0,2},
                {0,0,7,0,9,14,0,0},
                {0,0,0,9,0,10,0,0},
                {0,0,4,14,10,0,2,0},
                {0,11,0,0,0,2,0,1},
                {8,0,2,0,0,0,1,0}
        };

        Question_3 obj = new Question_3();
        obj.dijkstra(graph, 0);
    }
}