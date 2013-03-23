package test;

import utils.IComparator;
import utils.QuickSort;
import algorithms.Point2f;
import algorithms.XYComparator;
import algorithms.RadialComparator;

import java.io.*;
import io.*;
import utils.*;

/**
 *
 * @author Teemu Linkosaari
 */
class MyMath {

	/**
	  * Laskee kahden pisteen välisen kulman.
	  * Luokka on vain testausta varten.
	  * @.pre { origon y-koordinaatti <= a:n y-koordinaatti }
	  * .@pre {  RESULT == kulma radiaaneina && 0 <= RESULT <= PI}
	  */
	public static double getAngle(Point2f o, Point2f a) {

		if( o == a ) return -1.0d; // pisteen kulma itsensä suhteen ei määritelty
	
		double eps = 0.0009;
		assert o.getY() - eps <= a.getY(): "\nepatosi: ";
		
		double dy = a.getY()  - o.getY();
		assert dy + eps >= 0;
		
		double dx = a.getX() - o.getX();
		
		if( dx > 0 )
			return Math.atan( dy / dx );		
		else
			return Math.PI/2 + Math.atan( -dx / dy );
	}
}



public class TestRadialComparator {

	/**
	 *
	 */
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
		} else

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
		} else

		if( n == 2 ) {
			try {
				List<Point2f> lista = DataReader.readData("data2D1.txt");
				taulu = new Point2f[ lista.size() ];
				taulu = lista.toArray(taulu);	
			} catch( IOException e) {
				System.out.println("File error.");
				System.exit(-1);
			}
		} else

		if( n == 3 ) {
			try {
				List<Point2f> lista = DataReader.readData("data2D2.txt");
				taulu = new Point2f[ lista.size() ];
				taulu = lista.toArray(taulu);	
			} catch( IOException e) {
				System.out.println("File error.");
				System.exit(-1);
			}
		} else  {
			throw new AssertionError("Testidata ei oikea.");
		}

		return taulu;
	}
	
	/**
	 * Tulostaa syötteen tulostinvirtaan.
	 */ 
	private static void tulostaPisteet( Point2f[] input ) {
		System.out.println("Before: {");		
		for(Point2f p : input)
			System.out.println( "{" + p.getX() + "," + p.getY() + "}," );
		System.out.println("}");	
	}
	
	/**
	 *
	 */
	public static void main(String[] args) {

		System.out.println("Testing QuickSort with RadialComparator");
		Point2f[] tc = getTestData( 2 );

		// Lajittele y-koordinaatit kasvavasti, nyt tc[0] on pienin.
		QuickSort.<Point2f>sort( tc, new XYComparator() );
		
		Point2f origo = tc[0];
		
		// lajittele origin suhteen
		QuickSort.<Point2f>sort( tc, new RadialComparator( tc[0] ) );

		// nyt origo on listan viimeinen, koska kulmaa ei ole määritelty.
		assert origo == tc[ tc.length - 1] : "\norigo on muuttunut";
	
		// tulostetaan kulmat origon suhteen.
		System.out.println( "Listan koko on " + tc.length );
		
		double prev = 0;
		double cur = 0;
		
		for( int i = 0; i <= tc.length - 2; i++ ) {
			assert prev <= cur: "loppuehtoa rikottu, jarjestys ei ole kasvava";
			System.out.println( i + " " + MyMath.getAngle( tc[ tc.length - 1 ], tc[i] ) );
		}

		System.out.println("Ei loytynyt virheita.");
	}
}
