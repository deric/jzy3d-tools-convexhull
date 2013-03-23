
package test;

import io.*;
import utils.*;
import algorithms.*;
import convexhull.*;

import java.io.IOException;

public class TestPerformance {
 
	/**
	 * Luo n kpl pisteitä satunnaisesti.
	 */
	private static Point2f[] generate(int n) {
		assert n >= 0;
		
		Point2f[] t = new Point2f[n];
		
		java.util.Random gen = new java.util.Random();
		
		for( int i = 0; i < n; i++ ) {
			double x = 500 - 1000*gen.nextDouble();
			double y = 500 - 1000*gen.nextDouble();
			t[i] = new Point2f( x , y );
			
			assert t[i] != null;
		}
		
		assert t != null;
		
		return t;
	}
	
	public static void main(String[] args) {
		
		System.out.println("pisteet, aika (ms)");
		
		System.out.print("jarvis = ");
		runTest(new JarvisMarch(), 300);
		
		System.out.print("graham = ");
		runTest(new GrahamScan(), 300);
  	}
	
	/**
	 * Tulostaa (pisteet ja ajan)  generoimalla tuhannen välein aina
	 * tuhannet*1000 pisteeseen saakka funktiolla f.
	 */
	private static void runTest(ConvexHullFunction f, int tuhannet) {		
		System.out.println("{");
		for( int i = 200; i <= tuhannet; i++ ) {
			int pts = 1000*i;
			System.out.print("{" + pts);
			Point2f[] p = generate( pts );
			
			long t1 = System.currentTimeMillis();
			f.getConvexHull( p );
			long t2 = System.currentTimeMillis();
			
			System.out.println( "," + (t2 - t1) + "}," );
		}
		System.out.println("}");
	}
}