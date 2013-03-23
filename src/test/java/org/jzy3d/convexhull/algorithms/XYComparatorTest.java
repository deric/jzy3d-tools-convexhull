package org.jzy3d.convexhull.algorithms;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jzy3d.convexhull.Fixtures;
import org.jzy3d.convexhull.io.DataReader;
import org.jzy3d.convexhull.utils.List;
import org.jzy3d.convexhull.utils.QuickSort;

/**
 *
 * @author deric
 */
public class XYComparatorTest {

    private static Fixtures fixtures;

    public XYComparatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        fixtures = new Fixtures();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class XYComparator.
     */
    @Test
    public void testCompare() {
        System.out.println("Testing QuickSort with XYComparator");

        Point2f[] taulu = getTestData(2);

        /*System.out.println("Before:");
         for (int ii = 0; ii < taulu.length; ii++) {
         System.out.println(taulu[ii] + " ");
         }
         System.out.println();
         */
        QuickSort.<Point2f>sort(taulu, new XYComparator());

        System.out.println("After Quicksort:");
        int j = 1;
        for (int ii = 0; ii < taulu.length; ii++) {
            assertTrue(taulu[ii].getY() <= taulu[j].getY());
            //System.out.println(taulu[ii] + " " + ii);
            j = ii + 1;
        }

    }

    private static Point2f[] getTestData(int n) {

        Point2f[] taulu = null;

        if (n == 0) {
            taulu = new Point2f[5];
            int i = 0;
            taulu[i++] = new Point2f(3.0, 0.0);
            taulu[i++] = new Point2f(2.0, 3.0);
            taulu[i++] = new Point2f(2.0, 2.0);
            taulu[i++] = new Point2f(2.0, 1.0);
            taulu[i++] = new Point2f(1.0, 0.0);
        }

        if (n == 1) {
            taulu = new Point2f[8];
            int i = 0;
            taulu[i++] = new Point2f(-1.362, 2.226);
            taulu[i++] = new Point2f(-0.19, 0.16);
            taulu[i++] = new Point2f(-1.2, 1.794);
            taulu[i++] = new Point2f(0.15, 0.3);
            taulu[i++] = new Point2f(1, -1.53);
            taulu[i++] = new Point2f(1.19, 0.05);
            taulu[i++] = new Point2f(-1.524, 2.28);
            taulu[i++] = new Point2f(-1.117, 3.449);
        }

        if (n == 2) {
            try {
                File file = fixtures.data2();
                List<Point2f> lista = DataReader.readData(file);
                taulu = new Point2f[lista.size()];
                taulu = lista.toArray(taulu);
            } catch (IOException e) {
                System.out.println("File error.");
                System.exit(-1);
            }
        }
        return taulu;
    }
}