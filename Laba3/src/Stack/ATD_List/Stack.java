package Stack.ATD_List;

import Array.*;
import Container.Container;
import java.util.NoSuchElementException;
import Stack.ATD_Stack;

public class Stack implements ATD_Stack{
    private List stack;
    public Stack(){
        list = new List();
    }
    @Override
    public void push(Container x) {
        stack.Insert(stack.First(), x);
    }

    @Override
    public Container pop() {
        if (empty()) throw new NoSuchElementException("Стэк пуст");

        Container temp = stack.Retrieve(stack.First());
        stack.Delete(stack.First());
        return temp;
    }
    @Override
    public Container top() {
        if (empty()) throw new NoSuchElementException("Стэк пуст");
        return stack.Retrieve(stack.First());
    }

    @Override
    public boolean empty() {
        return stack.First().equals(stack.End());
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void makeNull() {
        stack.MakeNull();
    }
}
