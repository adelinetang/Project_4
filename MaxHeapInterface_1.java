/**
   An interface for the ADT maxheap.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface MaxHeapInterface<T extends Comparable<? super T>>
{  // See Segment 24.33 for a commented version.
   public void add(T newEntry);
   public T removeMax();
   public T getMax();
   public boolean isEmpty();
   public int getSize();
   public void clear();
} // end MaxHeapInterface
