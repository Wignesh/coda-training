package Ex.Lab1;

public class Ex3 {
    public static void main(String[] args) throws Exception {
        DynamicStack dynamicStack = (DynamicStack) Class.forName("Ex.Lab1.DynamicStack").getConstructor(int.class).newInstance(10);
        for (int i = 0; i <= 10; i++) {
            dynamicStack.push(i);
        }
        for (int i = 0; i <= 10; i++) {
            dynamicStack.pop();
        }

        FixedStack fixedStack = (FixedStack) Class.forName("Ex.Lab1.FixedStack").getConstructor(int.class).newInstance(10);
        for (int i = 0; i <= 10; i++) {
            fixedStack.push(i);
        }
        for (int i = 0; i <= 10; i++) {
            fixedStack.push(i);
        }

    }
}

interface Stack {
    void push(int data);

    int pop();

    boolean isStackFull();

    boolean isStackEmpty();

    int peek();
}


class DynamicStack implements Stack {
    public DynamicStack(int stackSize) {
        this.stackSize = stackSize;
        this.stackArray = new int[stackSize];
        this.top = -1;
    }

    int stackSize;
    int[] stackArray;
    int top;

    @Override
    public void push(int data) {
        System.out.println("Adding: " + data);
        if (this.isStackFull()) {
            System.out.println("Stack Overflow");
            this.increaseStackCapacity();
        }
        this.stackArray[++top] = data;
    }

    @Override
    public int pop() {
        if (this.isStackEmpty()) {
            System.out.println("Stack underflow.");
        }
        int data = this.stackArray[top--];
        System.out.println("Removed entry: " + data);
        return data;
    }

    @Override
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    @Override
    public boolean isStackEmpty() {
        return (top == -1);
    }

    @Override
    public int peek() {
        return stackArray[top];
    }

    private void increaseStackCapacity() {
        int[] newStack = new int[this.stackSize * 2];
        if (stackSize >= 0) System.arraycopy(this.stackArray, 0, newStack, 0, stackSize);
        this.stackArray = newStack;
        this.stackSize = this.stackSize * 2;
    }
}

class FixedStack implements Stack {

    public FixedStack(int stackSize) {
        this.stackSize = stackSize;
        this.stackArray = new int[stackSize];
        this.top = -1;
    }

    int stackSize;
    int[] stackArray;
    int top;

    @Override
    public void push(int data) {
        if (this.isStackFull()) {
            System.out.println("Stack Overflow");
        }
        System.out.println("Adding: " + data);
        this.stackArray[++top] = data;
    }

    @Override
    public int pop() {
        if (this.isStackEmpty()) {
            System.out.println("Stack underflow.");
        }
        int data = this.stackArray[top--];
        System.out.println("Removed entry: " + data);
        return data;
    }

    @Override
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    @Override
    public boolean isStackEmpty() {
        return (top == -1);
    }

    @Override
    public int peek() {
        return stackArray[top];
    }

}