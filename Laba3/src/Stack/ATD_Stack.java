package Stack;
import Container.Container;
public interface ATD_Stack {
    public void push(Container x);
    public Container pop();
    public Container top();
    public boolean empty();
    public boolean full();
    public void makeNull();
}
