/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

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
