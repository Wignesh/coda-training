//4. Write a program to implement stack of integer numbers.

package Ex.Lab2;

public class Ex4 {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print("Stack: ");
        stack.printStack();

        stack.pop();
        System.out.println("\nAfter popping out");
        stack.printStack();
    }
}

class Stack {

    private final int[] stack;
    private int top;
    private final int capacity;

    Stack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");
        }
        stack[++top] = x;
    }

    public void pop() {

        if (isEmpty()) {
            System.out.println("STACK EMPTY");
        }
        top--;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + ", ");
        }
    }
}