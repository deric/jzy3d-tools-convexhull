package test;

import algorithms.Converter;
import algorithms.Point2f;

public class TestConverter {

	public static void testFrom( Converter c ) {
	
		System.out.println("FROM");
	
		Point2f[] p = new Point2f[ 10 ];
		boolean ehto;
		int i=0,x,y;

		p[i] = c.from( new Point2f(0, 0) );
		ehto = (int)p[i].getX() == 150 && (int)p[i].getY() == 100;
		assert  ehto: "\nTest " + i + " failed " + p[i];
		i++;
		
		p[i] = c.from( new Point2f(10, 0) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 300 && y == 100;
		assert  ehto: "\nTest " + i + " failed " + p[i];		
		i++;
		
		p[i] = c.from( new Point2f(-10, 0) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 0 && y == 100;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.from( new Point2f(0, 10) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 150 && y == 0;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.from( new Point2f(0, -10) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 150 && y == 200;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.from( new Point2f(5, 5) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 225 && y == 50;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.from( new Point2f(5, -5) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 225 && y == 150;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;	

		p[i] = c.from( new Point2f(10, -10) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 300 && y == 200;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;

		p[i] = c.from( new Point2f(-10, 10) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 0 && y == 0;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;		
		
		System.out.println("No errors found.");
		
	}
	
	public static void testTo( Converter c ) {
	
		System.out.println("TO");
			
		Point2f[] p = new Point2f[ 10 ];
		boolean ehto;
		int i=0,x,y;
		
		p[i] = c.to( new Point2f(150, 100) );
		ehto = (int)p[i].getX() == 0 && (int)p[i].getY() == 0;
		assert  ehto: "\nTest " + i + " failed " + p[i];
		i++;
		
		p[i] = c.to( new Point2f(300, 100) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 10 && y == 0;
		assert  ehto: "\nTest " + i + " failed " + p[i];		
		i++;
		
		p[i] = c.to( new Point2f(0, 100) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == -10 && y == 0;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.to( new Point2f(0, 0) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == -10 && y == 10;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.to( new Point2f(150, 200) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 0 && y == -10;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.to( new Point2f(225, 50) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 5 && y == 5;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;
		
		p[i] = c.to( new Point2f(225, 150) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 5 && y == -5;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;	

		p[i] = c.to( new Point2f(300, 200) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == 10 && y == -10;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;

		p[i] = c.to( new Point2f(0, 0) );
		x = (int)p[i].getX();
		y = (int)p[i].getY();
		ehto =  x == -10 && y == 10;
		assert  ehto: "\nTest " + i + " failed " + p[i];				
		i++;		
		
		System.out.println("No errors found.");
		
	}	
	public static void main(String[] args) {
		
		// Muunotaa koordinaatiston.
		Converter c = new Converter(300, 200, 10, 10);
		
		testFrom( c );
		testTo( c );
		
		//testTo(c );
	}
}