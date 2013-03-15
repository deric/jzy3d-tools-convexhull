
package convexhull;

import utils.Stack;
import utils.LinkedStack;
import utils.QuickSort;
import algorithms.Point2f;
import algorithms.RadialComparator;

/**
 * @author Jukka Moisio
 */ 
public class GrahamScan implements ConvexHullFunction {

        /**
		 *
		 */
        private Point2f[] preSort(Point2f[] pts)
        {
            Point2f t;

            // find the lowest point in the set. If two or more points have
            // the same minimum y coordinate choose the one with the minimu x.
            // This focal point is put in array location pts[0].
            for (int i = 1; i < pts.length; i++)
            {
                if ((pts[i].getY() < pts[0].getY()) || ((pts[i].getY() == pts[0].getY() ) 
                     && (pts[i].getX() < pts[0].getX() )))
                {
                    t = pts[0];
                    pts[0] = pts[i];
                    pts[i] = t;
                }
            }

            // sort the points radially around the focal point.
            QuickSort.sort(pts, new RadialComparator(pts[0]));

            return pts;
        }

	/**
	 * implements interface
	 * @author Jukka Moisio
	 */
	public Stack<Point2f> getConvexHull(Point2f[] pts){
		Point2f[] sorted = preSort(pts);
		Point2f p;
		RadialComparator c = new RadialComparator(pts[0]);
		
		// palautettava pino
		Stack<Point2f> s = new LinkedStack<Point2f>();
        
		s.push(pts[pts.length - 1]);
		s.push(pts[0]);
		s.push(pts[1]);
		for (int i = 2; i < pts.length - 1; i++) {
				p = s.pop();
				c.setOrigin(s.peek());;
				
				while (c.compare(p, pts[i]) > 0) {
					p = s.pop();
					c.setOrigin(s.peek());
				}
				
				s.push(p);
				s.push(pts[i]);
		}
		
		// Tarkistetaan vielä, pitääkö viimeiseksi lisätyn pisteen
		// todella kuulua pinoon.
		p = s.pop();
		
		c.setOrigin(s.peek());
		if (c.compare(p, pts[pts.length - 1]) <= 0)
			s.push(p);

		s.push( pts[pts.length - 1] ); 
			
		return s;
	}
}