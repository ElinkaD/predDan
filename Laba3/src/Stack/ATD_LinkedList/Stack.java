package Stack.ATD_LinkedList;

import Container.Container;
import Stack.ATD_Stack;

import java.util.NoSuchElementException;

public class Stack implements ATD_Stack{
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

    private Node head;
    @Override
    public void push(Container x) {
        Container copy_x = new Container(x);
        if (head == null) {
            head = new Node(copy_x);
        } else {
            head = new Node(copy_x, head);
        }
    }

    @Override
    public Container pop() {
        if (head == null) throw new NoSuchElementException("Стэк пуст");
        Container temp = head.container;
        head = head.next;
        return temp;
    }

    @Override
    public Container top() {
        if (head == null) throw new NoSuchElementException("Стэк пуст");
        return new Container(head.container);
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void makeNull() {
        head = null;
    }
}
