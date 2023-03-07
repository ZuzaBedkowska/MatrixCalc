package Math;
import java.lang.Math.*;


public class Matrix {
    private final int n;
    private final int m;
    private double det;
    private int rank;
    public Double[][] elements;
    public Double[][] transposed;
    public Double[][] inversed;
    public Matrix (int newN, int newM) {
        n = newN;
        m = newM;
        elements = new Double[n][m];
        transposed = new Double[m][n];
        inversed = new Double[m][n];
    }
    public double getDet() {
        return det;
    }
    public int getRank() {
        return rank;
    }
    public void setElement(int id1, int id2, double value) {
        elements[id1][id2] = value;
    }
    public void diagonal() {
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < m; ++j) {
                double mnoznik = elements[j][i]/elements[i][i];
                for (int k = i; k < n; ++ k) {
                    elements[j][k] -= mnoznik * elements[i][k];
                }
            }
        }
    }
    public void calculateDet() {
        try {
            if (n != m) {
                throw new Exception("Number of rows is different that number of columns!");
            } else {
                det = 0;
                for (int i = 0; i < n; ++i) {
                    det += elements[0][i%n]*elements[1][(1 + i)%n]*elements[2][(2 + i)%n];
                }
                for (int i = 0; i <n; ++i) {
                    det-= elements[2][i%n]*elements[1][(1 + i)%n]*elements[0][(2 + i)%n];
                }
            }
        } catch (Exception e) {
            String message = "Sth went wrong!\n";
            if (e.getMessage() != null) {
                message += e.getMessage();
                message += "\n";
            }
            message += "Please try again!\n";
        }
    }
    public void calculateRank() {
        diagonal();
        rank = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (elements[i][j] != 0) {
                    rank++;
                    break;
                }
            }
        }
    }
    public void transpose() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                transposed[j][i] = elements[i][j];
            }
        }
    }
    public void inverse() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Matrix c = new Matrix(2, 2);
                int kskip = 0;
                for (int k = 0; k < n; ++k) {
                    if (k == i) {
                        kskip++;
                        continue;
                    }
                    int lskip = 0;
                    for (int l = 0; l < m; ++l) {
                        if (l == j) {
                            lskip++;
                            continue;
                        }
                        c.setElement(k - kskip, l - lskip, elements[k][l]);
                    }
                }
                double cdet = c.elements[0][0]*c.elements[1][1]-c.elements[0][1]*c.elements[1][0];
                inversed[j][i] = cdet*Math.pow(-1, i + j)/det;
            }
        }

    }
    public void sum(Matrix a, Matrix b) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                elements[i][j] = a.elements[i][j] + b.elements[i][j];
            }
        }
    }
    public void sub(Matrix a, Matrix b) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                elements[i][j] = a.elements[i][j] - b.elements[i][j];
            }
        }
    }
    public void mul(Matrix a, Matrix b) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                elements[i][j] = 0.0;
                for (int k = 0; k < n; ++k) {
                    elements[i][j] += a.elements[i][k]*b.elements[k][j];
                }
            }
        }
    }
}
