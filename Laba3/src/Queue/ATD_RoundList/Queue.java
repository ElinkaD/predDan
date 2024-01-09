package Queue.ATD_RoundList;

import Container.Container;
import Queue.ATD_Queue;
import Stack.ATD_LinkedList.Stack;

import java.util.NoSuchElementException;

public class Queue implements ATD_Queue{
    private static class Node {
        private Container container;
        private Node next;
        public Node(Container container, Node next) {
            this.container = container;
            this.next = next;
        }
        public Node(Container container) {
            this(container, null);
        }
    }

    private Node tail;
    @Override
    public void enqueue(Container x) {
        if (empty()){
            tail = new Node(x);
            tail = tail.next;
        }
        else{
            tail.next = new Node(x,tail.next);
            tail = tail.next;
        }
    }

    @Override
    public Container dequeue() {
        if (empty()) throw new NoSuchElementException("Очередь пуста");
        Container temp = tail.container;
        if (tail == tail.next){
            tail = null;
        }
        else{
            tail.next = tail.next.next;
        }
        return temp;
    }

    @Override
    public Container front() {
        if (empty()) throw new NoSuchElementException("Очередь пуста");
        return new Container(tail.container);
    }

    @Override
    public boolean empty() {
        return tail == null;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void makeNull() {
        tail = null;
    }
}
