package test;

import utils.IComparator;
import utils.QuickSort;
import algorithms.Point2f;
import algorithms.XYComparator;

import java.io.*;
import io.*;
import utils.*;

public class TestXYComparator {

	private static Point2f[] getTestData( int n ) {

		Point2f[] taulu = null;

		if( n == 0 ) {
			taulu = new Point2f[ 5 ];
			int i=0;
			taulu[i++] = new Point2f( 3.0, 0.0 );
			taulu[i++] = new Point2f( 2.0, 3.0 );
			taulu[i++] = new Point2f( 2.0, 2.0 );
			taulu[i++] = new Point2f( 2.0, 1.0 );
			taulu[i++] = new Point2f( 1.0, 0.0 );
		}

		if( n == 1 ) {
			taulu = new Point2f[ 8 ];
			int i=0;
			taulu[i++] = new Point2f(-1.362, 2.226);
			taulu[i++] = new Point2f(-0.19, 0.16);
			taulu[i++] = new Point2f(-1.2, 1.794);
			taulu[i++] = new Point2f(0.15, 0.3);
			taulu[i++] = new Point2f(1, -1.53);
			taulu[i++] = new Point2f(1.19, 0.05);
			taulu[i++] = new Point2f(-1.524, 2.28);
			taulu[i++] = new Point2f(-1.117, 3.449);
		}

		if( n == 2 ) {
			try {
				List<Point2f> lista = DataReader.readData("data2D2.txt");
				taulu = new Point2f[ lista.size() ];
				taulu = lista.toArray(taulu);	
			} catch( IOException e) {
				System.out.println("File error.");
				System.exit(-1);
			}
		}
		return taulu;
	}

	public static void main(String[] args) {

		System.out.println("Testing QuickSort with XYComparator");
		
		Point2f[] taulu = getTestData( 2 );

		System.out.println("Before:");		
		for(int ii = 0; ii < taulu.length; ii++)
			System.out.println( taulu[ii] + " " );
		System.out.println();

		QuickSort.<Point2f>sort( taulu, new XYComparator() );

		System.out.println("After Quicksort:");
		int j = 1;
		for(int ii = 0; ii < taulu.length; ii++) {
			assert taulu[ii].getY() <= taulu[j].getY();
			System.out.println( taulu[ii] + " " + ii);
			j = ii+1;
		}
		System.out.println();
	}
}