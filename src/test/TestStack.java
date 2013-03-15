package test;

import convexhull.*;
import utils.*;

/**
 *
 * @author Teemu
 */
public class TestStack {
    
    public static void listTest() {
        List<Integer> lista = new LinkedList<Integer>();
        lista.insert(12);
        assert lista.delete(12) == 12;        
    }
    
    public static void stackTest() {

       	Stack<Integer> pino = new LinkedStack<Integer>();

		// ensimmäinen testi
		for(int i = 1; i <= 10; i++)
        		pino.push(i);

		assert pino.size() == 10;

		for(int i = 10; i > 0; i--)
			assert pino.size() == i && pino.pop() == i;

		assert pino.size() == 0;

		//toinen testi
		for(int i = 1; i <= 10; i++)
        		pino.push(i);
        	while (!pino.empty()) {
            	System.out.println( pino.pop() );
        	}
    }

    public static void main(String[] args) {
		System.out.println("Running TestStack...");
        	stackTest();
    }
}
