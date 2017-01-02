// Linked stack implementation
class LStack implements Stack {
    // Pointer to first element
    private Link top;
    // Number of elements
    private int size;

    // Constructors
    LStack() {
        top = null;
        size = 0;
    }

    LStack(int size) {
        top = null;
        size = 0;
    }

    // Reinitialize stack
    public void clear() {
        top = null;
        size = 0;
    }

    // Put "it" on stack
    public boolean push(Object it) {
        top = new Link(it, top);
        size++;
        return true;
    }

    // Remove "it" from stack
    public Object pop() {
        if (top == null) {
            return null;
        }
        Object it = top.element();
        top = top.next();
        size--;
        return it;
    }

    // Return top value
    public Object topValue() {
        if (top == null) {
            return null;
        }
        return top.element();
    }

    // Return stack length
    public int length() {
        return size;
    }
}