package List.LinkedList;

import List.Container.Container;
import java.util.NoSuchElementException;

public class List{

    private Node head; //Первый узел списка

    // Конструктор класса List
    public List() {
        this.head = null; // Инициализируем головной узел как null, создавая пустой список
    }
    public List(Node head) {
        this.head = head; // Инициализируем список с один элементом в качестве головы
    }
    // Внутренний класс Node, элемент связного списка(ссылка и объект)
    static class Node{
        private Container containers;
        private Node next; // Следующий узел

        // Конструктор класса Node
        private Node(Container c, Node n) {
            containers = c; // Присваиваем переданный объект Container
            next = n; // Присваиваем переданный узел Node переменной next
        }
    }

    //Метод вставляет сообщение x на позицию p
    public void Insert(Position p, Container x) {
        //Проверка существования позиции и элемента
        if (p == null || x == null) return;
        //Создание копии объекта для вставки
        Container new_x = new Container(x);

        // 1. Если список пуст (head == null),
        //         1.создаем новый узел с объектом Container и null в качестве следующего узла, и делаем его узлом head
        if (head == null) {
            head = new Node(new_x, null);
            return;
        }
        // 2. Если вставка после последнего узла/первого свободного
        //        1. Создаем новый узел с объектом Container и null в качестве следующего узла
        //        2. Получаем последний узел в списке с помощью метода lastNode()
        //        3. Подсоединяем ссылку на следующий узел после последнего узла как новый узел
        if (p.getNode() == null) {
            Node newnode = new Node(new_x, null);
            Node last = lastNode();
            last.next = newnode;
            return;
        }

        // 3. Во всех других вариантах
        //       1. Проверяем вставка ли в голову
        //          Если так, то вставляем в голову новый узел с ссылкой на прошлый head
        //       2. Во всех оставшихся случаев (вставка в середину) получаем предыдущий узел указанной позиции с помощью метода previousNode()
        //          1. Если он не равен 0
        //              Node current = prev.next; // Получаем текущий узел с помощью ссылки на следующий узел у предыдущего узла
        //              Node newnode = new Node(current.containers, current.next); // Создаем новый узел с объектом Container текущего узла и ссылкой на следующий узел.
        //              Заменяем объект Container текущего узла на новый объект Container.
        //              Присоединяем ссылку на следующий узел как на новый узел.
        if (p.getNode() == head) {
            head = new Node(new_x, head);
        } else {
            Node prev = previousNode(p);
            if (prev != null) {
                Node cur = prev.next;
                Node newnode = new Node(cur.containers, cur.next);
                cur.containers = new_x;
                cur.next = newnode;
            }
        }
    }

    // Вспомогательный метод lastNode() используется для поиска последнего узла в списке
    private Node lastNode(){
        Node last = null; // Инициализируем переменную last как null
        Node current = head; // Устанавливаем текущий узел как головной узел списка
        //1. Массив while пока текущий не станет равен null(последнему элементу)
            //1. Запоминаем текущий узел в переменной last
            //2. Переходим к следующему узлу
        //2. Возвращаем последний узел (переменную last)
        while (current != null){
            last = current;
            current = current.next;
        }
        return last;
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
        //В случае если ничего не нашли возвращаем null
        return null;
    }
    //возвращается объект списка L в позиции p

    public Container Retrieve(Position p) {
        //1. Проверяем, является ли позиция p равной null. Если это так, выбрасываем исключение
        //2. Если узел из позиции p равен головному узлу (head), это означает, что позиция p указывает на голову списка.
        //      Возвращаем объект из головного узла (head.containers).
        //3. Получаем предыдущий узел (prev) для указанной позиции p с помощью метода previousNode(p)
        //4. Если предыдущий узел (prev) равен null, это означает, что позиция p недопустима или не существует предыдущего узла, выбрасываем исключение
        //5. Если предыдущий узел найден, получаем узел (n), следующий за предыдущим узлом (текущий) и возвращаем объект текущего
        if (p.getNode() == null)
            throw new NoSuchElementException();
        if (p.getNode() == head)
            return new Container(head.containers);

        Node prev = previousNode(p);
        if (prev == null)
            throw new NoSuchElementException();

        Node findnode = prev.next;
        return new Container(findnode.containers);
    }

    //удалить элемент списка L в позиции p

    public void Delete(Position p) {
        //1. получаем узел (n) из указанной позиции p с помощью метода getNode().
        //2. Если узел (n) равен головному узлу (head), значит, мы хотим удалить голову списка.
                    //1. Обновляем голову списка (head) на следующий узел за головным (head.next).
                    //2. Завершаем метод с помощью оператора return.
        Node n = p.getNode();
        if(n == head){
            head = head.next;
            return;
        }
        //3. Случай когда голова равна хвосту
        if (head == lastNode()){
            head = null;
        }
        //4. Если узел (n) не является головным узлом, мы продолжаем выполнение метода.
        //5. Получаем предыдущий узел (prev) для указанной позиции p с помощью метода previousNode(p).
        //6. Если предыдущий узел (prev) равен null, это означает, что позиция p недопустима или не существует предыдущего узла. В этом случае просто завершаем метод.
        Node prev = previousNode(p);
        if (prev == null){
            return;
        }
        //7. Если предыдущий узел найден, обновляем его ссылку prev.next на следующий узел после n.
        //8. Обновляем узел в позиции p (p.setNode(n.next)), чтобы он ссылался на узел, следующий за удаленным узлом.
        prev.next = n.next;
        p.setNode(n.next);
    }
    //возвращает следующую за p позицию в списке L

    public Position Next(Position p) {
        //1. Затем проверка, Если p равно null или (узел из p не равен головному узлу (head) и предыдущий узел для p равен null),
        //           то выбрасываем исключение (Результат не определен, если p нет в списке или p=END(L) (выбросить исключение))
        //          Если условия не выполняются, продолжаем выполнение метода.
        //2. Создаем новую позицию (Position) с узлом, следующим за узлом из p, и возвращаем эту позицию.
        if (p.getNode() == null || (p.getNode() != head && previousNode(p) == null))
            throw new IllegalArgumentException("Нет следующий позиции.");
        return new Position(p.getNode().next);
    }
    //возвращает предыдущую перед p позицию в списке L

    public Position Previous(Position p) {
        //1. Затем проверка, Если p равно null или p соответствует головному узлу (head),
        //                  метод выбрасываем исключение (Результат не определен, если p = 1, p = END(L) или позиции p нет в списке L (выбросить исключение).)
        //2. Обращаемся к методу previousNode(Position p), чтобы получить предыдущий узел для указанной позиции p
        //3. Если полученный предыдущий узел (prev) равен null, выбрасываем исключение
        //4. Если предыдущий узел найден, создаем новую позицию (Position) с этим узлом и возвращаем ее
        if (p.getNode() == null || p.getNode() == head)
            throw new NoSuchElementException("Нет предыдущей позиции.");

        Node prev = previousNode(p);
        if (prev == null)
            throw new NoSuchElementException("Нет предыдущей позиции.");

        return new Position(prev);
    }
    //Вспомогательный поиск предыдущего узла относительно указанной позиции p.
    private Node previousNode(Position p) {
        Node current = head;
        Node prev = null;
        Node n = p.getNode(); //Получаем узел из указанной позиции p с помощью метода getNode().
        // С помощью цикла while перебираем узлы списка.
            //Если узел (n) равен текущему узлу (current), возвращаем предыдущий узел (prev).
            //В противном случае обновляем предыдущий узел (prev) и текущий узел (current) и переходим к следующему узлу.
        //Если достигнут конец списка и не был найден узел (n), возвращаем null.
        while (current != null){
            if (n == current) return prev;
            prev = current;
            current = current.next;
        }
        return null;
    }


    public Position First() {
        //возвращает новый объект класса Position с начальным значением head
        return new Position(head);
    }

    public Position End(){
        return new Position(null);
    }

    public void MakeNull() {
        head = null; //приравниваем голове null
    }

    //вывод списка на печать в порядке расположения элементов в списке

    public void PrintList(){
        // получаем главный узел в позицию n
        // цикл до тех пор, пока узел не будет равен null
            //получаем значение объекта узла в переменную new_cont
                //цикл для вывода имен
                //цикл для вывода адресов
        //  перенос ссылки на след узел
        Node n = head;
        if (n == null)
            return;
        Node current = n;
        System.out.println("Двухсвязный список: ");
        while(current != null){
            System.out.print(" Name: "+current.containers.NameToString()+" Address: "+ current.containers.AddressToString()+" \n");
            current=current.next;
        }
        System.out.println();
    }
}
