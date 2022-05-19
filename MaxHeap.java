import java.util.Arrays;
import data.txt;

public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
    private T[] heap;      // Array of heap entries; ignore heap[0]
    private int lastIndex; // Index of last entry and number of entries
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
    }// end checkCapacity

    private void ensureCapacity(){
        if (lastIndex >= heap.length - 1) {// If array is full, double its size
            int newLength = 2 * heap.length;
            checkCapacity(newLength);
        } // end if
    } // end ensureCapacity

    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    }// end checkIntegrity

    public MaxHeap()
   {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor
   
    public MaxHeap(int initialCapacity){
        // Is initialCapacity too small?
        if (initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        }else { // Is initialCapacity too big?
            checkCapacity(initialCapacity);
        }

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked");
        T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    } // end constructor

    public MaxHeap(T[] entries){
        this(entries.length);//call other constructor
        assert initialized = true;
        //copy given array to data field
        for(int index = 0; index < entries.length; index++){
            heap[index + 1] = entries[index];
        }
        //create heap
        for(int rootIndex = lastIndex/2; rootIndex > 0; rootIndex++){
            reheap(rootIndex);
        }
    }//end constructor

    public void add(T newEntry){
        checkIntegrity();        // Ensure initialization of data fields
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        } // end while

        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    } // end add

    public T removeMax() {
        checkIntegrity();             // Ensure initialization of data fields
        T root = null;

        if (!isEmpty()) {
            root = heap[1];            // Return value
            heap[1] = heap[lastIndex]; // Form a semiheap
            lastIndex--;               // Decrease size
            reheap(1);                 // Transform to a heap
        } // end if

        return root;
    } // end removeMax

   public T getMax() {
        checkIntegrity();
        T root = null;
        if (!isEmpty()) {
            root = heap[1];
        }
        return root;
   } // end getMax

   public boolean isEmpty() {
        return lastIndex < 1;
   } // end isEmpty

   public int getSize() {
        return lastIndex;
   } // end getSize

   public void clear() {
        checkIntegrity();
        while (lastIndex > -1) {
            heap[lastIndex] = null;
            lastIndex--;
        } // end while
        lastIndex = 0;
   } // end clear

    public maxHeapPrint(T[] heap){
        int indexNum = 0;
        for (int indexNum; indexNum >= heap.length; indexNum++){
            System.out.println(heap[indexNum]);
        }
    }

} // end MaxHeap
