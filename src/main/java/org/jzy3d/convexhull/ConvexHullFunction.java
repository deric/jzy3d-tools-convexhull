package org.jzy3d.convexhull;

import java.util.Deque;
import org.jzy3d.convexhull.algorithms.Point2f;


public interface ConvexHullFunction {

    public Deque<Point2f> getConvexHull(Point2f[] pts);
}