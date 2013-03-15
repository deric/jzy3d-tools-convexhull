package convexhull;

import utils.Stack;
import algorithms.Point2f;

public interface ConvexHullFunction {
	public Stack<Point2f> getConvexHull( Point2f[] pts );
}