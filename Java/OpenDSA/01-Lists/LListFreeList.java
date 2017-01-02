// Linked list implementation
class LList implements List {
    private Link head;         // Pointer to list header
    private Link tail;         // Pointer to last element
    private Link curr;         // Access to current element
    private int listSize;      // Size of list

    // Constructors
    LList(int size) {
        // Constructor -- Ignore size
        this();
    }

    LList() {
        clear();
    }

    // Remove all elements
    public void clear() {
        // Create trailer
        curr = tail = new Link(null);
        // Create header
        head = new Link(tail);
        listSize = 0;
    }

    public void moveToStart() {
        // Set curr at list start
        curr = head.next();
    }

    public void moveToEnd() {
        // Set curr at list end
        curr = tail;
    }

    // Move curr one step left; no change if now at front
    public void prev() {
        if (head.next() == curr) {
            // No previous element
            return;
        }
        Link temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) {
            temp = temp.next();
        }
        curr = temp;
    }

    // Move curr one step right; no change if now at end
    public void next() {
        if (curr != tail) {
            curr = curr.next();
        }
    }

    public int length() {
        // Return list length
        return listSize;
    }

    // Return the position of the current element
    public int currPos() {
        Link temp = head.next();
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    // Move down list to "pos" position
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) {
            return false;
        }
        curr = head.next();
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        return true;
    }

    // Return true if current position is at end of the list
    public boolean isAtEnd() {
        return curr == tail;
    }

    // Return current element value. Note that null gets returned if curr is at the tail
    public Object getValue() {
        return curr.element();
    }

    // Insert "it" at current position
    public boolean insert(Object it) {
        curr.setNext(Link.get(curr.element(), curr.next())); // Get link
        curr.setElement(it);
        if (tail == curr) tail = curr.next();    // New tail
        listSize++;
        return true;
    }

    // Append "it" to list
    public boolean append(Object it) {
        tail.setNext(Link.get(null, null));
        tail.setElement(it);
        tail = tail.next();
        listSize++;
        return true;
    }

    // Remove and return current element
    public Object remove() {
        if (curr == tail) {

            // Nothing to remove
            return null;
        }
        // Remember value
        Object it = curr.element();
        // Pull forward the next element
        curr.setElement(curr.next().element());
        // Removed last, move tail
        if (curr.next() == tail) tail = curr;
        // Remember the link
        Link tempptr = curr.next();
        // Point around unneeded link
        curr.setNext(curr.next().next());
        // Release the link
        tempptr.release();
        // Decrement element count
        listSize--;
        // Return value
        return it;
    }

}