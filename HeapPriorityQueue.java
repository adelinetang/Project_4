public final class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private MaxHeapInterface<T> pq;	
	
	public HeapPriorityQueue()
	{
		pq = new MaxHeap<>();
	} // end default constructor
	
	public void add(T newEntry)
	{ 
		pq.add(newEntry);
	} // end add

	public reheap();

} // end HeapPriorityQueue
