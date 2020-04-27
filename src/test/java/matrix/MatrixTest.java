package matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


class MatrixTest {
    double[][]stringToMatrix(String str) {
        double[][] a;
        String [] rows = str.split("\n");
        a = new double[rows.length][rows.length];
        for (int i =0;i<rows.length;i++) {
            String[] elemsInRow = rows[i].split(",");
            for(int j=0;j<elemsInRow.length;j++) {
                a[i][j] = Double.parseDouble(elemsInRow[j]);
            }
        }
        return a;
    }

    @Test
    void sum() {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{5, 6}, {7, 8}};
        double[][] expected = {{6, 8}, {10, 12}};
        assertArrayEquals(expected,Matrix.sum(a,b));
    }

    @Test
    void mult() {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{5, 6}, {7, 8}};
        double[][] expected = {{19, 22}, {43, 50}};
        assertArrayEquals(expected, Matrix.mult(a, b));
    }

    @Test
    void sub() {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{5, 6}, {7, 8}};
        double[][] expected = {{-4, -4},{-4, -4}};
        assertArrayEquals(expected,Matrix.sub(a,b));
    }
    @Test
    void multiplyByNum() {
        double num = 5;
        double[][] a = {{1, 2}, {3, 4}};
        double[][] expected = {{5, 10},{15, 20}};
        assertArrayEquals(expected,Matrix.multiplyByNum(a,5));
    }

    @Test
    void devideByNum() {
        double num = 2;
        double[][] a = {{1, 2}, {3, 4}};
        double[][] expected = {{0.5, 1},{1.5, 2}};
        assertArrayEquals(expected,Matrix.devideByNum(a,2));
    }

    @Test
    void fileMult() {
        double[][]a= null;
        double[][]b = null;
        double[][]expected = null;
        try (InputStream inputStream = getClass().getResourceAsStream("/mat1.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            a = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/mat2.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            b = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/mult.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            expected = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected,Matrix.mult(a,b));
    }

    @Test
    void fileSum() {
        double[][]a= null;
        double[][]b = null;
        double[][]expected = null;
        try (InputStream inputStream = getClass().getResourceAsStream("/mat1.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            a = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/mat2.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            b = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/sum.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            expected = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected,Matrix.sum(a,b));
    }

    @Test
    void fileSubtract() {
        double[][]a= null;
        double[][]b = null;
        double[][]expected = null;
        try (InputStream inputStream = getClass().getResourceAsStream("/mat1.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            a = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/mat2.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            b = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/sub.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            expected = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected,Matrix.sub(a,b));
    }

    @Test
    void fileMultiplyByNum() {
        double[][]a= null;
        double num = 5;
        double[][]expected = null;
        try (InputStream inputStream = getClass().getResourceAsStream("/mat1.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            a = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/multiplyByNum.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            expected = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected,Matrix.multiplyByNum(a,num));
    }

    @Test
    void fileDevideByNum() {
        double[][]a= null;
        double num = 2;
        double[][]expected = null;
        try (InputStream inputStream = getClass().getResourceAsStream("/mat1.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            a = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = getClass().getResourceAsStream("/devideByNum.txt")) {
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            expected = stringToMatrix(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(expected,Matrix.devideByNum(a,num));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,10,15,20",
            "5,6,7,8,25,30,35,40"})
    void multiplyByValueParam(String num1,String num2,String num3,String num4,
                              String num5,String num6,String num7,String num8) {
        double num = 5;
        double [][] expected = {{Double.parseDouble(num5),Double.parseDouble(num6)},
                {Double.parseDouble(num7),Double.parseDouble(num8)}};
        double [][] a = {{Double.parseDouble(num1),Double.parseDouble(num2)},
                {Double.parseDouble(num3),Double.parseDouble(num4)}};
        assertArrayEquals(expected,Matrix.multiplyByNum(a,num));
    }
}
