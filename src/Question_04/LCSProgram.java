package Question_04;

public class LCSProgram {

        public static void main(String[] args) {

            String string1 = "FURQANSHAIKH";
            String string2 = "ETAOINSHR";

            int m = string1.length();
            int n = string2.length();

            int[][] lcs = new int[m + 1][n + 1];

            // Building LCS table
            for (int i = 0; i <= m; i++) {

                for (int j = 0; j <= n; j++) {

                    if (i == 0 || j == 0) {

                        lcs[i][j] = 0;
                    }

                    else if (string1.charAt(i - 1) == string2.charAt(j - 1)) {

                        lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    }

                    else {

                        lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                    }
                }
            }

            System.out.println("Length of LCS = " + lcs[m][n]);
        }


}
