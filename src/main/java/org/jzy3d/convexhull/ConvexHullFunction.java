package org.jzy3d.convexhull;

import org.jzy3d.algorithms.Point2f;
import org.jzy3d.utils.Stack;


public interface ConvexHullFunction {

    public Stack<Point2f> getConvexHull(Point2f[] pts);
}