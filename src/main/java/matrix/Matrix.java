package matrix;

public class Matrix {
    public static double[][] sum(double[][] firstMatrix, double[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length)
            return null;
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                result[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return result;
    }

    public static double[][] mult(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static double[][] sub(double[][] firstMatrix, double[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length)
            return null;
        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                result[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyByNum(double[][] matrix, double num) {
        double[][] res = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[i][j] = num * matrix[i][j];
            }
        }
        return res;
    }

    public static double[][] devideByNum(double[][] matrix, double num) {
        double newNam = 1.0/num;
        return multiplyByNum(matrix,newNam);
    }

    public static void print(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
