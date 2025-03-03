package com.yuan.array.test;

public class ArrayQueue {
    private Object[] queue; // 存储队列元素的数组
    private int front;      // 队头指针
    private int rear;       // 队尾指针
    private int size;       // 队列当前大小
    private int capacity;   // 队列容量

    // 构造函数，初始化队列
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // 入队操作
    public void enqueue(Object x) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = x; // 将元素放入队尾
        rear = (rear + 1) % capacity; // 循环队列，队尾指针后移
        size++;
    }

    // 出队操作
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object value = queue[front]; // 获取队头元素
        queue[front] = null; // 清除引用，帮助垃圾回收
        front = (front + 1) % capacity; // 循环队列，队头指针后移
        size--;
        return value;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return size == capacity;
    }

    // 获取队列当前大小
    public int size() {
        return size;
    }

    // 打印队列内容（用于调试）
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue("Hello");
        queue.enqueue(123);
        queue.enqueue(45.67);
        queue.printQueue(); // 输出: Hello 123 45.67

        System.out.println("Dequeue: " + queue.dequeue()); // 输出: Hello
        queue.printQueue(); // 输出: 123 45.67

        queue.enqueue(true);
        queue.enqueue('A');
        queue.printQueue(); // 输出: 123 45.67 true A

        System.out.println("Dequeue: " + queue.dequeue()); // 输出: 123
        queue.printQueue(); // 输出: 45.67 true A
    }
}