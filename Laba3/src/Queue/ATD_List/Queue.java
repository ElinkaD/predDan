package Queue.ATD_List;

import Array.*;
import Container.Container;
import Queue.ATD_Queue;

import java.util.NoSuchElementException;

public class Queue implements ATD_Queue{
    private List queue;
    public Queue(){
        queue = new List();
    }

    @Override
    public void enqueue(Container x) {
        queue.Insert(queue.First(), x);
    }

    @Override
    public Container dequeue() {
        if (empty()) throw new NoSuchElementException("Очередь пуста");
        Container temp = queue.Retrieve(queue.First());
        queue.Delete(queue.First());
        return temp;
    }

    @Override
    public Container front() {
        if (empty()) throw new NoSuchElementException("Очередь пуста");
        return queue.Retrieve(queue.First());
    }

    @Override
    public boolean empty(){
        return queue.First().equals(queue.End());
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void makeNull() {
        queue.MakeNull();
    }
}
