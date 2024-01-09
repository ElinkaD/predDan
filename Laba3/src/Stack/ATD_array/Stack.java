package Stack.ATD_array;

import Container.Container;
import Stack.ATD_Stack;

import java.util.NoSuchElementException;

public class Stack implements ATD_Stack{
    private final static int LENGTH = 5;
    private final Container[] array;
    private int head;
    public Stack() {
        array = new Container[LENGTH];
        head = 0;
    }

    @Override
    public void push(Container x) {
        if (head == 5) throw new NoSuchElementException("Стэк переполнен");
        array[head++] = new Container(x);
    }

    @Override
    public Container pop() {
        if (head == 0) throw new NoSuchElementException("Стэк пуст");
        return array[head--];
    }

    @Override
    public Container top() {
        if (head == 0) throw new NoSuchElementException("Стэк пуст");
        return new Container(array[head]);
    }

    @Override
    public boolean empty() {
        return head == 0;
    }

    @Override
    public boolean full() { return head == 5; }

    @Override
    public void makeNull() {
        head = 0;
    }
}
