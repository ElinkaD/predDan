package List.Cursor;

import List.Container.Container;
import java.util.NoSuchElementException;

public class List{

    private static final int SIZE = 6; //размерность таблицы
    private static final Node[] reclist = new Node[SIZE];
    private static int SPACE = 0;
    private int start;

    //Статический блок
    static {
        for (int i = SPACE; i < SIZE - 1; i++) {
            reclist[i] = new Node(null, i + 1);
        }
        reclist[SIZE - 1] = new Node(null, -1);
    }

    // пустой список
    public List() {
        start = -1;
    }

    static class Node {
        private Container containers;
        private int next; // число указатель на следующую позицию
        private Node(Container container, int n) {
            this.containers = container;
            this.next = n;
        }
        //Копирующий конструктор
        private Node(Node node){
            if(node != null){
                containers = node.containers;
                next = node.next;
            }
        }
    }


    //Вставка элемента x в позицию p
    public void Insert(Position p, Container x) {
        Container new_x = new Container(x);
        //Если список курсоров заполнен
        if (SPACE == -1){
            throw new NoSuchElementException("Список курсоров заполнен");
        }
        int nextSpace = reclist[SPACE].next;

        //пустой список
        if(start == -1){
            start = SPACE;
            //Создается новый узел в reclist с элементом x и ссылкой на следующий узел установленной в -1
            reclist[start] = new Node(new_x, -1);
            SPACE = nextSpace;
            return;
        }
        //Вставка в конец
        if(p.getPos() == -1){
            int last = lastNode();
            //Создается новый узел в reclist с элементом x и ссылкой на следующий узел установленной в -1
            reclist[SPACE] = new Node(new_x, -1);
            //Затем устанавливается ссылка на следующий узел предыдущего последнего узла, и значение SPACE обновляется на nextSpace
            reclist[last].next = SPACE;
            SPACE = nextSpace;
            return;
        }
        //Вставка в head элемент(начало) не пустого списка
        //Создается новый узел, взятый из начального узла, и со ссылкой на следующий узел установленной в начальной позиции start
        if (p.getPos() == start) {
            reclist[SPACE] = new Node(reclist[start].containers, reclist[start].next);
            //Элемент начального узла устанавливается в x
            reclist[start].containers = new_x;
            //Ссылка на следующий узел начального узла устанавливается в начальную позицию start.
            reclist[start].next = start;
            start = SPACE;
            SPACE = nextSpace;
        }

        //Вставка в середину списка
        int pos = findPrevious(p);
        //Если позиция вставки существует
        if (pos != -1) {
            //Устанавливается ссылка предыдущей позиции на новый узел SPACE
            reclist[pos].next = SPACE;
            pos = SPACE; //Переменная pos присваивается значению SPACE
            SPACE = nextSpace; //Значение SPACE обновляется на nextSpace.
            reclist[pos] = new Node(new_x, -1); ////Создается новый узел в reclist с элементом x и ссылкой на следующий узел установленной в -1
        }
    }

    //Вспомогательный метод findPrevious() используется для поиска предыдущего элемента в списке
    //1. Инициализируем переменные для начала current как начало, pos полученная и предыдущий -1
    //2. Цикл пока current не станет концом(-1)
    //  1. Если текущая позиция равна полученной - Если равна возвращаем предыдущий
    //  2. Присваиваем предыдущей позиции текущую
    //  3. Переносим указатель на следующий элемент
    //3. Иначе возвращаем (-1) -- не нашли(
    private int findPrevious(Position p) {
        int pos = p.getPos();
        int current = start;
        int prev = -1;
        while (current != -1) {
            if (current == pos)
                return prev;
            prev = current;
            current = reclist[current].next;
        }
        return -1;
    }

    // Вспомогательный метод lastNode() используется для поиска последнего узла в списке
    private int lastNode(){
        int last = -1; // Инициализируем переменную last как -1
        int current = start; // Устанавливаем текущий узел как головной узел списка
        //1. Массив while пока текущий не станет равен -1(последнему элементу)
        //1. Запоминаем текущий узел в переменной last
        //2. Переходим к следующему узлу
        //2. Возвращаем последний узел (переменную last)
        while (current != -1){
            last = current;
            current = reclist[current].next;
        }
        return last;
    }

    //1.Поиск элемента в списке
    //  1.На каждой итерации цикла проверяется, является ли нащ элемент равным переданному
    //      если мы находим совпадение элемента в списке, возвращается в качестве результата новый объект Position.
    //  2.Переход к следующему элементу
    //2.Если после завершения цикла не было найдено совпадение, метод возвращает новый объект Position с параметром -1
    public Position Locate(Container x) {
        int current = start;
        while (current != -1) {
            if (reclist[current].containers.equals(x))
                return new Position(current);
            current = reclist[current].next;
        }
        return new Position(-1);
    }

    //используется для извлечения элемента из списка по указанной позиции
    public Container Retrieve(Position p) {
        //список пуст
        if (start == -1)
            throw new NoSuchElementException("Список пуст");

        //Если позиция это голова - Возвращаем копию ее значения
        if (p.getPos() == start)
            return new Container(reclist[start].containers);

        int prev = findPrevious(p); //ищем позицию предыдущего
        if (prev == -1) throw new NoSuchElementException(); //элемент не найден


        int current = reclist[prev].next; //зная позицию предыдущего с помощью next перемещаемся к текущей
        return new Container(reclist[current].containers); //возвращаем копию
    }
    //Удаление элемента по позиции
    public void Delete(Position p) {
        int pos = p.getPos();

        //Проверка удаления элемента в начале списка
        if (pos == start) {
            //Устанавливаем контейнер начальной позиции в null, обнуляем связь у начальной позиции
            //обновляем SPACE на начальную позицию, обновляем начальную позицию start на next и завершаем выполнение метода.
            int next = reclist[start].next;
            reclist[start].containers = null;
            reclist[start].next = SPACE;
            SPACE = start;
            start = next;
            return;
        }
        //поиск предыдущей позиции элемента prev с помощью метода findPrevious(p)
        //Если метод findPrevious возвращает -1 (то есть предыдущая позиция не найдена), завершаем  метод
        int prev = findPrevious(p);
        if (prev == -1)
            return;

        //Если предыдущая позиция найдена, получаем текущую позицию current элемента, который нужно удалить
        //Обновляем позицию элемента p на позицию следующего элемента после удаляемого элемента
        int current = reclist[prev].next;
        p.setPos(reclist[current].next);

        //Обновляем связи между узлами, убирая удаляемый элемент из списка и обновляя значение SPACE
        reclist[prev].next = reclist[current].next;
        reclist[current].containers = null;
        reclist[current].next = SPACE;
        SPACE = current;
    }
    //Возвращает следующую позицию
    public Position Next(Position p) {
        // начинаем с проверки, равна ли позиция p начальной позиции start. Если это так, мы создаем и возвращаем новую позицию, которая указывает на следующий элемент после начальной позиции
        if (p.getPos() == start)
            return new Position(reclist[start].next);
        //Если не можем найти предыдущую позицию, генерируем исключение NoSuchElementException
        int prev = findPrevious(p);
        if (prev == -1)
            throw new NoSuchElementException("Позиции не существует");

        return new Position(reclist[p.getPos()].next);
    }
    //Возвращает предыдущую позициюс сообщением о том, что предыдущая позиция не существует, поскольку начальная позиция не имеет предыдущей позиции.
    //Ищем предыдущую позицию с помощью метода findPrevious(p).
    //не нашла предыдущую позицию, генерируем исключение NoSuchElementException
    //В конце,  возвращаем новую позицию, указывающую на предыдущий элемент перед позицией p.
    public Position Previous(Position p) {
        if (p.getPos() == start)
            throw new NoSuchElementException("Предыдущей позиции не существует");

        int prev = findPrevious(p);
        if (prev == -1)
            throw new NoSuchElementException("Предыдущей позиции не существует");

        return new Position(prev);
    }

    //Возвращает первую позиция списка. Если список пуст, то End()
    public Position First() {
        return new Position(start);
    }

    //обнуление списка, проходясь по всем элементам в цикле
    //1.Инициализация переменной current приcваивая начальную переменную
    //2.Цикл по всем элементам пока не дойдем до конца (current != -1)
    //  1. Производим очистку данных, присваивая всем элементам null
    //  2.Затем сохраняется следующий указатель nextCur на узел
    //  3.Указатель next устанавливается в значение SPACE, позволяя использовать узел для новых элементов
    //  4.Переменная SPACE устанавливается в значение current, освобождая узел для будущего
    //  5.Обновляем current, переходя к следующему узлу в списке
    public void MakeNull() {
        int current = start;
        while (current != -1) {
            reclist[current].containers = null;
            int nextCur = reclist[current].next;
            reclist[current].next = SPACE;
            SPACE = current;
            current = nextCur;
        }
        start = -1;
    }

    //вывод содержимого списка на экран
    public void PrintList() {
        int current = start;
        System.out.println("Курсоры: ");
        while(current != -1){
                System.out.print(" Name: "+reclist[current].containers.NameToString()+" Address: "+ reclist[current].containers.AddressToString()+" \n");
                current = reclist[current].next;
        }
    }

    //Возвращает пустую позицию после последнего элемента
    public Position End() {
        return new Position(-1);
    }
}