package com.challenge.sonusunos.pascaltriangle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Author: karab on 11/07/15.
 */
public class PascalTriangleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetCoefficient() throws Exception {

        assertEquals(PascalTriangle.getBinomialCoefficient(0, 0), 1);
        assertEquals(PascalTriangle.getBinomialCoefficient(1, 0), 1);
        assertEquals(PascalTriangle.getBinomialCoefficient(1, 1), 1);

        assertEquals(PascalTriangle.getBinomialCoefficient(10, 10), 1);
        assertEquals(PascalTriangle.getBinomialCoefficient(30, 15), 155117520);

    }

    @Test
    public void testNegativeRowIndexes() throws Exception {
        exception.expect(Exception.class);
        PascalTriangle.getBinomialCoefficient(-1, 1);
    }

    @Test
    public void testNegativeColumnIndexes() throws Exception {
        exception.expect(Exception.class);
        PascalTriangle.getBinomialCoefficient(1, -1);
    }

    @Test
    public void testNegativeRowColumnIndexes() throws Exception {
        exception.expect(Exception.class);
        PascalTriangle.getBinomialCoefficient(-1, -1);
    }

    @Test
    public void testOutOfBoundColumnIndexes() throws Exception {
        exception.expect(Exception.class);
        PascalTriangle.getBinomialCoefficient(0, 10);
    }


}