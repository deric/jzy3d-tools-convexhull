
package test;

import utils.*;

class BasicComparator implements IComparator<Integer> {		
	public int compare( Integer a, Integer b ) {
		return a.compareTo(b);
	}
}

public class TestQuickSort {


	public static void main(String[] args) {
		System.out.println("Testing QuickSort...");
		Integer[] taulu = { 2, 8, 7, 1, 3, 5, 6, 4 };

		// tulosta
		System.out.print("In:  ");
		for ( Integer a :	 taulu )
			System.out.print( a + " " );
		System.out.println();
		
		// lajittele
		QuickSort.<Integer>sort( taulu , new BasicComparator() );

		// tulosta
		System.out.print("Out: ");
		for ( Integer a :	 taulu )
			System.out.print( a + " " );
		System.out.println();
	
	}
}