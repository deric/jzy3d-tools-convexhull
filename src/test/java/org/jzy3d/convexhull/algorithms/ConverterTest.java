package org.jzy3d.convexhull.algorithms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deric
 */
public class ConverterTest {

    private static Converter c;

    public ConverterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //converts a coordinate system
        c = new Converter(300, 200, 10, 10);
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
     * Test of to method, of class Converter.
     */
    @Test
    public void testTo() {
        System.out.println("TO");

        Point2f[] p = new Point2f[10];
        boolean ehto;
        int i = 0, x, y;

        p[i] = c.to(new Point2f(150, 100));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(0, x);
        assertEquals(0, y);
        i++;

        p[i] = c.to(new Point2f(300, 100));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(10, x);
        assertEquals(0, y);        
        i++;

        p[i] = c.to(new Point2f(0, 100));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(-10, x);
        assertEquals(0, y);        
        i++;

        p[i] = c.to(new Point2f(0, 0));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(-10, x);
        assertEquals(10, y);        
        i++;

        p[i] = c.to(new Point2f(150, 200));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(0, x);
        assertEquals(-10, y);        
        i++;

        p[i] = c.to(new Point2f(225, 50));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(5, x);
        assertEquals(5, y);        
        i++;

        p[i] = c.to(new Point2f(225, 150));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(5, x);
        assertEquals(-5, y);        
        i++;

        p[i] = c.to(new Point2f(300, 200));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(10, x);
        assertEquals(-10, y);        
        i++;

        p[i] = c.to(new Point2f(0, 0));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(-10, x);
        assertEquals(10, y);        
        i++;
    }

    /**
     * Test of from method, of class Converter.
     */
    @Test
    public void testFrom() {
        System.out.println("FROM");

        Point2f[] p = new Point2f[10];
        int i = 0, x, y;

        p[i] = c.from(new Point2f(0, 0));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(150, x);
        assertEquals(100, y);
        i++;

        p[i] = c.from(new Point2f(10, 0));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(300, x);
        assertEquals(100, y);
        i++;

        p[i] = c.from(new Point2f(-10, 0));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(0, x);
        assertEquals(100, y);
        i++;

        p[i] = c.from(new Point2f(0, 10));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(150, x);
        assertEquals(0, y);
        i++;

        p[i] = c.from(new Point2f(0, -10));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(150, x);
        assertEquals(200, y);
        i++;

        p[i] = c.from(new Point2f(5, 5));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(225, x);
        assertEquals(50, y);
        i++;

        p[i] = c.from(new Point2f(5, -5));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(225, x);
        assertEquals(150, y);
        i++;

        p[i] = c.from(new Point2f(10, -10));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(300, x);
        assertEquals(200, y);
        i++;

        p[i] = c.from(new Point2f(-10, 10));
        x = (int) p[i].getX();
        y = (int) p[i].getY();
        assertEquals(0, x);
        assertEquals(0, y);
        i++;

        System.out.println("No errors found.");

    }
}