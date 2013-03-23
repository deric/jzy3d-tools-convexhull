
package test;

import io.*;
import utils.*;
import algorithms.*;
import convexhull.*;

import java.io.IOException;

public class TestGrahamScan {
 
	public static void main(String[] args) throws IOException {
		
		System.out.println("Testing GrahamScan.");

		ConvexHullFunction f = new GrahamScan();
		ConvexHullFunction f2 = new JarvisMarch();

		List<Point2f> lista = DataReader.readData("data2D2.txt");

		Point2f[] data = new Point2f[ lista.size() ];
		data = lista.toArray(data);

		Stack<Point2f> pino = f.getConvexHull( data );
		Stack<Point2f> pino2 = f2.getConvexHull( data );

		System.out.println("Size: " + pino.size());
		System.out.println("Size: " + pino2.size());

		System.out.println("No AssertionErrors found.");
  	}
}