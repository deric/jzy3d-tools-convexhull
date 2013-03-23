package org.jzy3d.convexhull;

import org.jzy3d.convexhull.algorithms.Point2f;
import org.jzy3d.convexhull.utils.Stack;


public interface ConvexHullFunction {

    public Stack<Point2f> getConvexHull(Point2f[] pts);
}