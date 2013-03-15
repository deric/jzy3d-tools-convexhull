
package test;

import java.io.IOException;

import io.DataReader;
import utils.List;
import algorithms.Point2f;

public class TestDataReader {
 
	public static void main(String[] args) {

		readFile("data2D1.txt");
		readFile("data2D2.txt");
  	}

	public static void readFile(String filename) {
		try {
      		List<Point2f> lista = DataReader.readData(filename);

			System.out.println("Reading " + filename );

			System.out.println("The number of keys is " + lista.size() );

			for( int i = 0; i < 4; i++)
				System.out.println("Piste "  + i + " = " + lista.search(i) );

			System.out.println("Viimeinen piste on " + lista.search( lista.size() - 1 ) );
		} catch( IOException e ) {
		}
	}
}