package week5;

import java.util.LinkedList;

public class GenericStack<E> {

    private LinkedList<E> list = new LinkedList<>();

    public void push( E item ) {
        list.addLast( item );
    }

    public E pop() {
        return list.removeLast();
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    /*
    // this version "Object[] toArray()" results in no compiler warning
    public Object[] toArray() {
        return list.toArray();
    }
    */
    // this version "E[] toArray()" results in compiler warning:
    //     Type safety: Unchecked cast from Object[] to E[]
    // which can be avoided with annotation:
    //     @SuppressWarnings( "unchecked" )
    @SuppressWarnings( "unchecked" )
    public E[] toArray() {
        return (E[]) list.toArray();
    }

} // GenericStack<E>
