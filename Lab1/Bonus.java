
package Homework;

public class Bonus {
    public static void createAdjancenyCycleGraph(int n){
        /* ca sa avem ciclu in graf, n trebuie sa fie >=3 */
        if(n<3)
        {
            throw new IllegalArgumentException("N must be 3 or more");
        }
        long[][] A = new long[n][n];

        /* Prima si ultima linie din matrice */

        A[0][n-1]=1; A[0][1]=1;
        A[n-1][0]=1; A[n-1][n-2]=1;

        /*  de la a doua la penultima linie din matrice */

        for(int i=1;i<n-1;i++) {
            A[i][i + 1] = 1;
            A[i][i-1]=1;
        }
        printMatrix(A,0);
        A=powerOfNMatrix(A,n);
    }
    public static void printMatrix(long[][] matrix,int cont)
    {
        if(cont==0) {
            System.out.print("\n\n" + "Adjanceny Matrix Cycle Graph of size " + matrix.length + ":" + "\n\n");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++)
                    System.out.print(matrix[i][j] + " ");
                System.out.print("\n");
            }
        } else
        {
            System.out.print("\n\n"+"Adjanceny Matrix ^"+cont+"\n\n");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++)
                    System.out.print(matrix[i][j] + " ");
                System.out.print("\n");
            }
        }
    }
    public static long[][] squareMatrix(long [][]A)
    {
        int size = A.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += A[i][k] * A[k][j];
                }
            }
        }
        return result;
    }

    public static long[][] powerOfNMatrix(long [][] A, int n)
    {
        int cont=1;
        while (n>1) {
            cont++;
            A=squareMatrix(A);
            printMatrix(A,cont);
            n--;
        }
        return A;
    }
}
