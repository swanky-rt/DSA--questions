public class Matrix {
    public static void getTranspose(int[][] A, int [][] B){
        for (int i=0; i<A.length; i++){
            for(int j=0; j< A.length; j++){
                B[j][i] = A[i][j];
            }
        }
    }

    public static void displayMatrix(int [][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int [][] A = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},};
        int [][] B = new int[A.length][A.length];
        displayMatrix(A);
        System.out.println("the transpose of matrix A is : ");
        getTranspose(A, B);
        displayMatrix(B);
    }
}
