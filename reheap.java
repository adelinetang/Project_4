private void reheap(int rootIndex){
    boolean done = false;
    T orphan = heap[rootIndex];
    int leftChildIndex = 2 * rootIndex;
    while(!done && (leftChildIndex <= lastIndex)){
        int largerChildIndex = leftChildIndex;  //assume larger
        int rightChildIndex = leftChildIndex + 1;
        if((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0){
            largerChildIndex = rightChildIndex;
        }//end if

        if(orphan.compareTo(heap[largerChildIndex]) < 0){
            heap[rootIndex] = heap[largerChildIndex];
            rootIndex = largerChildIndex;
            leftChildIndex = 2 * rootIndex;
        }else{
            done = true;
        }
    }//end while
    heap[rootIndex] = orphan;
}//end reheap