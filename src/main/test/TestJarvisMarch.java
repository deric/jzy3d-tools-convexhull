
package test;

import io.*;
import utils.*;
import algorithms.*;
import convexhull.*;

import java.io.IOException;

public class TestJarvisMarch {
 
	/**
	 *
	 */
	public static void main(String[] args) throws IOException {

		test1();
		test2();
	}

	/**
	 * @author Teemu Linkosaari
	 */
	public static void test1() {

		ConvexHullFunction f = new JarvisMarch();

		List<Point2f> lista;

		try {
			lista = DataReader.readData("data2D2.txt");
		} catch(IOException ioe) {
			throw new AssertionError("\nReading data2D2.txt failed!");
		}

		Point2f[] data = new Point2f[ lista.size() ];
		data = lista.toArray(data);

		Stack<Point2f> pino = f.getConvexHull( data );

		System.out.println( "\nListan koko: " + lista.size() );
		System.out.println( "Peitteen koko: " + pino.size() );

		System.out.println( "test1 finished." );
  	}

	/**
	 * @author Ossi Lehto
	 */
	public static void test2() {
		ConvexHullFunction f = new JarvisMarch();

		Point2f[] data = new Point2f[ 18 ];
		int i=0;
		data[i++]=new Point2f(0,0);//0
		data[i++]=new Point2f(1,-3);
		data[i++]=new Point2f(-3,-2);
		data[i++]=new Point2f(-1,-2.3);
		data[i++]=new Point2f(2,-1);
		data[i++]=new Point2f(4,1);//5
		data[i++]=new Point2f(3,2);
		data[i++]=new Point2f(3,4);
		data[i++]=new Point2f(2,6);
		data[i++]=new Point2f(1,5);
		data[i++]=new Point2f(-2,5);//10
		data[i++]=new Point2f(-4,3);
		data[i++]=new Point2f(-5,1);
		data[i++]=new Point2f(-4,0);
		data[i++]=new Point2f(-1,-1);
		data[i++]=new Point2f(-1,3);//15
		data[i++]=new Point2f(-3,2);
		data[i++]=new Point2f(-2,4);
				
		Stack<Point2f> pino = f.getConvexHull( data );

		System.out.println( "\nListan koko: " + data.length );
		System.out.println( "Peitteen koko: " + pino.size() );
		
		while(!pino.empty()) {
			System.out.println( pino.pop() );
		}

		System.out.println("test2 finished.");
  	}

}