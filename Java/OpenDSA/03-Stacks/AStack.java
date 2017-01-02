class AStack implements Stack {
    // Array holding stack
    private Object stackArray[];

    private static final int defaultSize = 10;
    // Maximum size of stack
    private int maxSize;
    // First free position at top
    private int top;

    // Constructors
    AStack(int size) {
        maxSize = size;
        top = 0;
        // Create stackArray
        stackArray = new Object[size];
    }

    AStack() {
        this(defaultSize);
    }

    // Reinitialize stack
    public void clear() {
        top = 0;
    }

    // Push "it" onto stack
    public boolean push(Object it) {
        if (top >= maxSize) {
            return false;
        }
        stackArray[top++] = it;
        return true;
    }

    // Remove and return top element
    public Object pop() {
        if (top == 0) {
            return null;
        }
        return stackArray[--top];
    }

    // Return top element
    public Object topValue() {
        if (top == 0) {
            return null;
        }
        return stackArray[top - 1];
    }

    public int length() {
        // Return stack size
        return top;
    }
}