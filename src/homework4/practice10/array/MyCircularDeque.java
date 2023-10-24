package homework4.practice10.array;

class MyCircularDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public MyCircularDeque(int k) {
        data = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        if (front == 0)
            front = data.length - 1;
        else
            front--;

        data[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        if (rear == data.length - 1)
            rear = 0;
        else
            rear++;

        data[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        if (front == data.length - 1)
            front = 0;
        else
            front++;

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        if (rear == 0)
            rear = data.length - 1;
        else
            rear--;

        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return data[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return data[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
