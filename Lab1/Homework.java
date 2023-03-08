
package Homework;

public class Homework {
    public static void CreateLatinSquare(int n) {

            // latin square -> similar to sudoku but size is variable

            int[][] latinSquare = new int[n][n];
            int i, j;

            long startTime = System.nanoTime();

            for (i = 1; i <= n; i++)
                latinSquare[0][i - 1] = i;

            for (i = 1; i < n; i++)
                for (j = 0; j < n; j++)
                    latinSquare[i][j] = latinSquare[i - 1][(j + 1) % n]; // left shift la elementele de pe linia anterioara

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            if(n<100) {
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        System.out.print(latinSquare[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }
            else{
                System.out.print("Total execution time: "+elapsedTime+"ns");
            }

    }
}
