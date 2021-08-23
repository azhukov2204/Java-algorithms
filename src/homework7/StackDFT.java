package homework7;

public class StackDFT {
    private final int[] stackArray;
    private int top;

    public StackDFT(int size) {
        this.stackArray = new int[size];
        this.top = -1;
    }

    public void push(int i) {
        stackArray[++top] = i;
    }

    public int pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int peek() {
        return stackArray[top];
    }
}
