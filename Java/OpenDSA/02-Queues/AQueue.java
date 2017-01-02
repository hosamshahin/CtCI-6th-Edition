class AQueue implements Queue {
    // Array holding queue elements
    private Object queueArray[];
    private static final int defaultSize = 10;
    // Maximum size of queue
    private int maxSize;
    // Index of front element
    private int front;
    // Index of rear element
    private int rear;

    // Constructors
    AQueue(int size) {
        // One extra space is allocated
        maxSize = size + 1;
        rear = 0;
        front = 1;
        // Create queueArray
        queueArray = new Object[maxSize];
    }

    AQueue() {
        this(defaultSize);
    }

    // Reinitialize
    public void clear() {
        rear = 0;
        front = 1;
    }

    // Put "it" in queue
    public boolean enqueue(Object it) {
        if (((rear + 2) % maxSize) == front) {
            return false;  // Full
        }
        rear = (rear + 1) % maxSize; // Circular increment
        queueArray[rear] = it;
        return true;
    }

    // Remove and return front value
    public Object dequeue() {
        if (length() == 0) {
            return null;
        }
        Object it = queueArray[front];
        front = (front + 1) % maxSize; // Circular increment
        return it;
    }

    // Return front value
    public Object frontValue() {
        if (length() == 0) {
            return null;
        }
        return queueArray[front];
    }

    // Return queue size
    public int length() {
        return ((rear + maxSize) - front + 1) % maxSize;
    }
}