package org.jzy3d.convexhull;

import java.util.Stack;
import org.jzy3d.convexhull.algorithms.Point2f;


public interface ConvexHullFunction {

    public Stack<Point2f> getConvexHull(Point2f[] pts);
}