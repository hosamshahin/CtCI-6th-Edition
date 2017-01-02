// Linked queue implementation
class LQueue implements Queue {
    // Pointer to front queue node
    private Link front;
    // Pointer to rear queuenode
    private Link rear;
    // Number of elements in queue
    private int size;

    // Constructors
    LQueue() {
        init();
    }

    LQueue(int size) {
        init();
    } // Ignore size

    // Initialize queue
    void init() {
        front = rear = new Link(null);
        size = 0;
    }

    // Put element on rear
    public boolean enqueue(Object it) {
        rear.setNext(new Link(it, null));
        rear = rear.next();
        size++;
        return true;
    }

    // Remove and return element from front
    public Object dequeue() {
        if (size == 0) {
            return null;
        }
        // Store the value
        Object it = front.next().element();
        // Advance front
        front.setNext(front.next().next());
        // Last element
        if (front.next() == null){
         rear = front;
        }
        size--;
        return it; // Return element
    }

    // Return front element
    public Object frontValue() {
        if (size == 0) return null;
        return front.next().element();
    }

    // Return queue size
    public int length() {
        return size;
    }
}