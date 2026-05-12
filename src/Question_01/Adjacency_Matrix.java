package Question_01;

public class Adjacency_Matrix {

        public static void main(String[] args) {

            int vertices = 4;

            int[][] graph = {
                    {0, 1, 1, 1},
                    {1, 0, 1, 1},
                    {1, 1, 0, 1},
                    {1, 1, 1, 0}
            };

            System.out.println("Adjacency Matrix:\n");

            for (int i = 0; i < vertices; i++) {

                for (int j = 0; j < vertices; j++) {

                    System.out.print(graph[i][j] + " ");
                }

                System.out.println();
            }
        }


}
