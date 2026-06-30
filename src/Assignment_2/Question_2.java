package Assignment_2;

public class Question_2 {

        static final int NO_OF_CHARS = 256;

        static void badCharHeuristic(char[] str, int size, int badchar[]) {

            for (int i = 0; i < NO_OF_CHARS; i++)
                badchar[i] = -1;

            for (int i = 0; i < size; i++)
                badchar[(int) str[i]] = i;
        }

        static void search(String txt, String pat) {

            int m = pat.length();
            int n = txt.length();

            int badchar[] = new int[NO_OF_CHARS];

            badCharHeuristic(pat.toCharArray(), m, badchar);

            int s = 0;

            while (s <= (n - m)) {

                int j = m - 1;

                while (j >= 0 && pat.charAt(j) == txt.charAt(s + j))
                    j--;

                if (j < 0) {

                    System.out.println("Pattern found at index " + s);

                    s += (s + m < n) ? m - badchar[txt.charAt(s + m)] : 1;
                } else {

                    s += Math.max(1, j - badchar[txt.charAt(s + j)]);
                }
            }
        }

        public static void main(String[] args) {

            String text = "Insertion sort typically has a smaller constant factor than merge sort";

            String pattern = "sort";

            search(text, pattern);
        }
    }
