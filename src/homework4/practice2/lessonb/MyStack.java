package homework4.practice2.lessonb;

class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    //Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        if (isEmpty()) {
            top = new StackNode(a);
        } else {
            StackNode nodeStack = new StackNode(a);
            nodeStack.next = top;
            top = nodeStack;
        }
    }

    //Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if (isEmpty())
            return -1;

        StackNode root = top;
        top = top.next;
        return root.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
