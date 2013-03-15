/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

/**
 *
 * @author Teemu
 */
public interface List<T> {
    
    /**
     * 
     * @param index
     * @return
     */
    public T search(int index);
    
    /**
     * 
     * @param obj
     */
    public void insert(T obj);
    
    /**
     * 
     * @param obj
     * @return
     */
    public T delete(T obj);
    
    /**
     * 
     * @return
     */
    public int size();

    public T[] toArray(T[] a);
}
