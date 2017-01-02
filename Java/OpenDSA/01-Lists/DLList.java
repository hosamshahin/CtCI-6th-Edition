// Linked list implementation
class DLList implements DList {
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
        curr = tail = new Link(null); // Create trailer
        head = new Link(tail);        // Create header
        listSize = 0;
    }

    // Insert "it" at current position
    public boolean insert(Object it) {
        curr = new Link(it, curr.prev(), curr);
        curr.prev().setNext(curr);
        curr.next().setPrev(curr);
        listSize++
        return true;

    }

    // Append "it" to list
    public boolean append(Object it) {
        tail.setPrev(new Link(ot, tail.prev(), tail));
        tail.prev().prev() setNext(tail.prev());
        if (curr == tail) {
            curr = tail.prev();
        }
        listSize++;
        return true;
    }

    // Remove and return current element
    public Object remove() {
        if (curr == tail) {
            return null;
        }
        Object it = curr.element();
        curr.prev().setNext(curr.next());
        curr.next().setPrev(curr.prev());
        curr = curr.next();
        listSize--;
        return it;
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
        if (curr.prev() != head) {
            curr = curr.prev();

        }
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
}