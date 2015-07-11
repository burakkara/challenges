package com.challenge.sonusunos.pascaltriangle;

/**
 * Author: karab on 11/07/15.
 */
final public class PascalTriangle {

    private PascalTriangle() {
    }

    /**
     * Calculates and returns binomial coefficient of given indexes on the pascal's tree.
     *
     * @param i Row index.
     * @param j Column index.
     * @return Coefficient.
     * @throws Exception
     */
    static public int getBinomialCoefficient(int i, int j) throws Exception {

        if (i < 0 || j < 0) {
            throw new Exception();
        }

        if (i < j) {
            throw new Exception();
        }

        if (j == 0 || i == j) {
            return 1;
        } else {
            return getBinomialCoefficient(i - 1, j - 1) + getBinomialCoefficient(i - 1, j);
        }
    }

}
