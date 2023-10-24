package homework4.practice6;

class MyQueue {
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a) {
        // Your code here
        if (front == null) {
            front = new QueueNode(a);
            rear = front;
        } else {
            QueueNode node = rear;
            rear = new QueueNode(a);
            node.next = rear;
        }
    }

    //Function to pop front element from the queue.
    int pop() {
        // Your code here
        if (front == null) {
            return -1;
        }
        QueueNode node = front;
        front = front.next;
        return node.data;
    }
}
