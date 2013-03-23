package org.jzy3d.convexhull;

import org.jzy3d.convexhull.algorithms.Point2f;

/**
 *
 * @author Tomas Barton
 */
public class PerformanceTest {

    /**
     * Luo n kpl pisteitä satunnaisesti.
     */
    private static Point2f[] generate(int n) {
        assert n >= 0;

        Point2f[] t = new Point2f[n];

        java.util.Random gen = new java.util.Random();

        for (int i = 0; i < n; i++) {
            double x = 500 - 1000 * gen.nextDouble();
            double y = 500 - 1000 * gen.nextDouble();
            t[i] = new Point2f(x, y);

            assert t[i] != null;
        }

        assert t != null;

        return t;
    }

    @org.junit.Test
    public void testPerformance() {

        System.out.println("pisteet, aika (ms)");

        System.out.print("jarvis ==== ");
        runTest(new JarvisMarch(), 250);

        System.out.print("graham ==== ");
        runTest(new GrahamScan(), 250);
    }

    /**
     * Tulostaa (pisteet ja ajan) generoimalla tuhannen välein aina
     * tuhannet*1000 pisteeseen saakka funktiolla f.
     */
    private static void runTest(ConvexHullFunction f, int tuhannet) {
        long total = 0;
        int start = 200;
        int runs = tuhannet - start;
        for (int i = start; i <= tuhannet; i++) {
            int pts = 100 * i;        
            Point2f[] p = generate(pts);

            long t1 = System.currentTimeMillis();
            f.getConvexHull(p);
            long t2 = System.currentTimeMillis();
            total += t2 - t1;
        }
        System.out.println("avg = " + (total / (double) runs));

        
    }
}
