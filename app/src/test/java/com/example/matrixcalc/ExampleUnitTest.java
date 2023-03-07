package com.example.matrixcalc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Math.Matrix;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @org.junit.jupiter.api.Test
    public void checkDiagonal() {
        Matrix testMatrix = new Matrix(3,3);
        testMatrix.elements = new Double[][]{{1.0, 2.0, 3.0}, {2.0,3.0,1.0}, {3.0, 1.0, 2.0}};
        Matrix goodMatrix = new Matrix(3,3);
        goodMatrix.elements = new Double[][]{{1.0, 2.0, 3.0}, {0.0,-1.0,-5.0}, {0.0, 0.0, 18.0}};
        testMatrix.diagonal();
        Assertions.assertArrayEquals(goodMatrix.elements, testMatrix.elements);
    }
    @Test
    public void checkDet() {
        Matrix testMatrix = new Matrix(3,3);
        testMatrix.elements = new Double[][]{{1.0, 2.0, 3.0}, {2.0,3.0,1.0}, {3.0, 1.0, 2.0}};
        double det = -18.0;
        testMatrix.calculateDet();
        Assertions.assertEquals(det, testMatrix.getDet());
    }

    @Test
    public void checkRank() {
        Matrix testMatrix = new Matrix(3, 3);
        testMatrix.elements = new Double[][]{{1.0, 1.0, 1.0}, {0.0,1.0,1.0}, {0.0, 1.0, 1.0}};
        double rank = 2;
        testMatrix.calculateRank();
        Assertions.assertEquals(rank, testMatrix.getRank());
        Matrix testMatrix2 = new Matrix(3, 3);
        testMatrix2.elements = new Double[][]{{1.0, 1.0, 1.0}, {0.0,1.0,1.0}, {0.0, 0.0, 1.0}};
        rank = 3;
        testMatrix2.calculateRank();
        Assertions.assertEquals(rank, testMatrix2.getRank());

    }
}