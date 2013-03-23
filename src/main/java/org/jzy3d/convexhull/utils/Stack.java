package org.jzy3d.convexhull.utils;

/**
 *
 * @author Teemu
 */
public interface Stack<T> {
    	public void push(T s);
    	public boolean empty();
    	public T pop();
   	public T peek();
	public int size();
}
