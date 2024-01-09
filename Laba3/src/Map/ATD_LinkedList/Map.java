package Map.ATD_LinkedList;

import Array.*;
import Container.Container;
import Map.ATD_Map;

public class Map implements ATD_Map{
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
    private Node head = null;
    //делает отображение пустым
    @Override
    public void Makenull() {
        head = null;
    }
    //делает M(d) равным r независимо от того, как M(d) было определено ранее.
    @Override
    public void Assign(char[] d, char[] r) {
        // Список пуст -> head == null
        if (head == null) {
            head = new Node(new Container(d,r),null);
            return;
        }
        //цикл по списку пока не дойдем до конца или не выполним замену
        Node temp = head;
        Node prev = null;
        while (temp != null){
            //Находим отображение c помощью метода сравнения двух массивов, для текущего списка, чтобы достать символьный массив по позиции используем Retrieve
            // заменяем его на M(r) и удаляем, выходя из цикла
            if (equalsArr(temp.container.getName(), d)){
                temp.container.setAddress(r);
                return;
            }
            //переходим на следующий элемент, меняя указатели prev и temp
            prev = temp;
            temp = temp.next;
        }
        //в случае если d не определено, создаем новый элемент
        prev.next = new Node(new Container(d,r),null);
    }
    //возвращает значение true и присваивает переменной r значение M(d), если последнее определено, и возвращает false в противном случае.
    @Override
    public boolean Compute(char[] d, char[] r) {
        //находим первую позицию и записываем ее в temp
        Node temp = head;
        //цикл по списку пока не дойдем до конца или не сработает if
        while (temp != null) {
            //Находим отображение c помощью метода сравнения двух массивов, для текущего списка, чтобы достать символьный массив по позиции используем Retrieve
            //  присваиваем переменной r значение M(d)
            if (equalsArr(temp.container.getName(), d)) {
                temp.container.setAddress(r);
                return true;
            }
            //переходим на следующий элемент
            temp = temp.next;
        }
        //в случае если d не определено, создаем новый элемент
        return false;
    }
    //сравнение элементов массивов
    private boolean equalsArr(char[] A, char[] B) {
        if (A.length != B.length) return false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }
}
