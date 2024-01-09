package Queue.ATD_Array;

import Container.Container;
import Queue.ATD_Queue ;

import java.util.NoSuchElementException;

public class Queue implements ATD_Queue{
    private final static int LENGTH = 5;
    private final Container[] array;
    private int head;
    private int tail;
    public Queue() {
        array = new Container[LENGTH];
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(Container x) {
        if (full()) throw new NoSuchElementException("Очередь переполнена");
        array[tail] = new Container(x);
        tail = next(tail);
    }

    private int next(int i){
        return (i + 1) % LENGTH;
    }

    @Override
    public Container dequeue() {
        if (empty()) throw new NoSuchElementException("Очередь пуста");
        Container temp = array[head];
        head = next(head);
        return temp;
    }

    @Override
    public Container front() {
        if (empty()) throw new NoSuchElementException("Очередь пуста");
        return new Container(array[head]);
    }

    @Override
    public boolean empty() {
        return tail == head;
    }

    @Override
    public boolean full() {
        return next(tail) == head;
    }

    @Override
    public void makeNull() {
        tail = head;
    }
}
