package List.DoubleLinkedList;

import List.Container.Container;
import java.util.NoSuchElementException;

public class List{

    private Node head; //Первый узел списка
    private Node tail;//Последний узел списка

    // Конструктор класса List
    public List() {
        head = null; // Инициализируем головной узел как null, создавая пустой список
    }

    // Внутренний класс Node, элемент связного списка(ссылка и объект)
    static class Node{
        private Container containers;
        private Node next; // Следующий узел
        private Node prev; //Предыдущий узел
        // Конструктор класса Node

        private Node(Node p, Container c, Node n) {
            prev = p; // Присваиваем переданный узел Node переменной prev
            containers = c; // Присваиваем переданный объект Container
            next = n;  // Присваиваем переданный узел Node переменной next
        }
    }

    //Метод вставляет сообщение x на позицию p
    public void Insert(Position p, Container x) {
        Container new_x = new Container(x);
        // 1. Если список пуст (head == null),
        //         1.создаем новый узел с объектом Container и null в качестве следующего узла, и делаем его узлом head
        //         2.приравниваем хвост к голове
        if (head == null) {
            head = new Node(null,new_x, null);
            tail = head;
            return;
        }
        // 2. Если вставка после последнего узла (p == null),
        //    1. Создаем новый узел с объектом Container и null в качестве следующего узла и tail в качестве предыдущего
        //    2. Присваиваем к следующему элементу после хвоста
        //    3. Переноси tail на новый элемент
        if (p.getNode() == null){
            Node newnode = new Node(tail, new_x, null);
            tail.next = newnode;
            tail = newnode;
            return;
        }
        // 3. Если вставка в голову
        //     1. Приравниваем голову к созданному Node с исходным элементом, предыдущего нет и бывшая голова в следующем
        if (p.getNode() == head) {
            head = new Node(null, new_x , head);
            return;
        }
        // 4. Если вставка в конец
        //      1. Приравниваем голову к созданному Node с исходным элементом, предыдущий старый tail и следующего элемента нет
        //      2. Значение containers узла current заменяется на новое значение c.
        //      3. Следующий узел за current устанавливается на созданный ранее newnode и переносится хвост списка
        if (p.getNode() == tail) {
            Node newnode = new Node(tail, tail.containers, null);
            tail.containers = new_x;
            tail.next = newnode;
            tail = newnode;
            return;
        }
        // 5. Во всех других вариантах
        //       1. Проверяем существует ли такая позиция в списке
        //          1. Если так, то в current заносим узел p
        //          2. Создаем новый узел newnode для вставки между двумя существующими узлами
        //          3. Значение containers узла current заменяется на новое значение c.
        //          4. Следующий узел за current устанавливается на созданный ранее newnode.
        if (positionExistInList(p)) {
            Node current = p.getNode();
            Node newnode = new Node(current, current.containers, current.next);
            current.containers = new_x;
            current.next = newnode;
        }
    }

    //возвращает позицию в списке L объекта x.
    public Position Locate(Container x) {
        //Создаем новый узел и приравниваем к нему голову
        Node current = head;
        //Проходимся по циклу от начала до конца
        while (current != null) {
            //Сравниваем элементы с полученным объектом. В случае истины возвращаем новый элемент позиции узла current
            if (current.containers.equals(x)) {
                return new Position(current);
            }
            //переходим к следующему узлу
            current = current.next;
        }
        return null;
    }
    //возвращается объект списка L в позиции p
    public Container Retrieve(Position p) {
        //1. Проверяем, что есть ли элемент в списке, если есть выводит
        //2. если нет выбрасываем исключение
        if (positionExistInList(p)) return new Container(p.getNode().containers);
        throw new NoSuchElementException("Нет позиции p в списке");
    }


    //удалить элемент списка L в позиции p
    public void Delete(Position p) {
        //1. Определяем узел n для соответствующего элемента в позиции p
        Node node = p.getNode();
        //2. Если список содержит только один элемент, то голова и хвост списка просто обнуляются
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        //2. Если удаляемый элемент находится в голове списка,
        //     1. то голова сдвигается на следующий элемент,
        //     2. предыдущая ссылка устанавливается в null
        if (node == head) {
            head = head.next;
            head.prev = null;
            return;
        }
        //3. Если удаляемый элемент находится в хвосте списка,
        //      1. то хвост сдвигается на предыдущий элемент
        //      2. следующая ссылка устанавливается в null
        //      3. а узел p устанавливается в null
        if (node == tail) {
            tail = tail.prev;
            tail.next = null;
            p.setNode(null);
            return;
        }
        // 4. В конце проверяем если существует позиция в списке
        //      1. узлы предыдущего и следующего элемента от удаляемого узла node перенаправляются мимо node,
         if (positionExistInList(p)){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return;
        }
    }
    //возвращает следующую за p позицию в списке L
    public Position Next(Position p) {
        //1. Проверка, Если p равно null или метод positionExistInList не находит искомый элемент
        //           то выбрасываем исключение (Результат не определен, если p нет в списке или p=END(L) (выбросить исключение))
        //          Если условия не выполняются, продолжаем выполнение метода.
        //2. Создаем новую позицию (Position) с узлом, следующим за узлом из p, и возвращаем эту позицию.
        if (p.getNode() == null || !positionExistInList(p))
            throw new IllegalArgumentException("Нет следующий позиции.");
        return new Position(p.getNode().next);
    }
    //возвращает предыдущую перед p позицию в списке L
    public Position Previous(Position p) {
        //1. Проверка, Если p равно null или метод positionExistInList не находит искомый элемент
        //                  метод выбрасываем исключение (Результат не определен, если p = 1, p = END(L) или позиции p нет в списке L (выбросить исключение).)
        //2. Создаем новую позицию (Position) с узлом, предыдущим узлом за p, и возвращаем эту позицию.
        if (p.getNode() == null || !positionExistInList(p))
            throw new NoSuchElementException("Нет предыдущей позиции.");
        return new Position(p.getNode().prev);
    }
    // Вспомогательный метод
    // Проверка наличия позиции в списке цикл по всему списку, который возвращает true/false в зависимости от результата
    private boolean positionExistInList(Position p) {
        Node current = head;
        Node pos = p.getNode();
        while (current != null) {
            if (current == pos){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Position First() {
        //возвращает новый объект класса Position с начальным значением head
        return new Position(head);
    }
    public Position End(){
        //Возвращаем пустую
        return new Position(null);
    }
    public void MakeNull() {
        head = null; //приравниваем голове null
        tail = null;
    }

    //вывод списка на печать в порядке расположения элементов в списке
    public void PrintList() {
        // получаем главный узел в позицию n
        // цикл до тех пор, пока узел не будет равен null
            //получаем значение объекта узла в переменную new_cont
                //цикл для вывода имен
                //цикл для вывода адресов
        //  перенос ссылки на след узел
        Node n = head;
        if (n == null || tail == null)
            return;
        else{
            Node current = n;
            System.out.println("Двумерный двусвязный список: ");
            while(current != null){
                System.out.print(" Name: "+current.containers.NameToString()+" Address: "+ current.containers.AddressToString()+" \n");
                current=current.next;
            }
            System.out.println();
            return;
        }
    }
}
