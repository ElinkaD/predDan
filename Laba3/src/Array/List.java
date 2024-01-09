package Array;

import Container.Container;
import java.util.NoSuchElementException;


public class List{
    private static final int SIZE = 6; //Граница массива
    private Container[] containers;
    private final Position last;//принимаем за первый свободный элемент в массиве

    //Конструктор, инициализирует объект класса List
    public List() {
        //1. Присваивает переменной last новый объект класса Position с начальным значением 0
        last = new Position(0);
        //2. Присваивает переменной containers объект класса Container с начальным значением SIZE + 1
        containers = new Container[SIZE + 1];
    }

    //Метод вставляет сообщение x на позицию p
    public void Insert(Position p, Container x) {
        //1. Получаем позицию pos из объекта p геттером getPos()
        //2. Проверка позиция pos находится в допустимом диапазоне (от 0 до значения последнего элемента last
        int pos = p.getPos();
        if (pos < 0 || pos > last.getPos()) return;
        //3. Выполняем перемещение элементов вправо
        //      1. Циклом проходимся от последнего элемента до позиции pos, в которую нужно вставить элемент
        //      2. Сдвигаем все элементы контейнера вправо на 1 позицию (containers[i] = containers[i - 1] перезаписываем в текущий элемент предыдущий двигаясь с конца в позиции pos(начало))
        for (int i = last.getPos(); i > pos; i--){
            containers[i] = containers[i - 1];
        }
        //4. Вставляем объект x на позицию pos
        //5. Увеличиваем значение last на 1 при помощи сеттера
        containers[pos] = new Container(x);
        last.setPos(last.getPos() + 1);
    }

    //возвращает позицию в списке L объекта x.
    public Position Locate(Container x) {
        //1. Если сообщение x равно null, то выбрасываем исключение
        //2. выполняем поиск с помощью цикла for, перебирая элементы массива x.
        //      1. Если сообщение найдено, метод возвращает новый объект Position с позицией первого вхождения сообщения.
        //3. Если сообщение не найдено, возвращается позиция last.
        if (x == null) throw new IllegalArgumentException();

        for (int i = 0; i < last.getPos(); i++) {
            if (x.equals(containers[i]))
                return new Position(i);
        }
        return last;
    }

    //возвращается объект списка L в позиции p
    public Container Retrieve(Position p) {
        //1. Получаем позицию pos из объекта p.getPos().
        //2. Проверка позиция pos находится в допустимом диапазоне (от 0 до значения last.getPos()).
        //      1. Если позиция недопустима, метод выбрасывает исключение
        //3. Если позиция допустима, метод возвращает сообщение на этой позиции containers[pos]
        int pos = p.getPos();
        if (pos < 0 || pos >= last.getPos())
            throw new NoSuchElementException();
        return containers[pos];
    }

    //удалить элемент списка L в позиции p
    public void Delete(Position p) {
        //1. Получаем позицию pos из объекта p.
        //2. Затем он проверяет, что позиция pos находится в допустимом диапазоне (от 0 до значения last.getPos()). Результат неопределен, если в списке L нет позиции p или p=END(L) (ничего не делать).
        //  1. Если позиция недопустима( pos < 0 or pos >= last.getPos()), метод просто возвращает управление.
        //3. Если позиция допустима, метод выполняет перемещение элементов влево
        //  1. Цикл от позиции pos до предпоследнего элемента массива
        //  2. Сдвигаем все элементы контейнера влево на 1 позицию
        //4. Значение last уменьшается на 1 при помощи сеттера,
        int pos = p.getPos();
        if (pos < 0 || pos >= last.getPos())
            return;

        for (int i = pos; i < last.getPos() - 1; i++){
            containers[i] = containers[i + 1];
        }
        last.setPos(last.getPos() - 1);
        containers[last.getPos()] = null;
    }

    //возвращает следующую за p позицию в списке L
    public Position Next(Position p) {
        //1. Получаем позицию pos из объекта p.
        //2. Затем проверка, что позиция pos находится в допустимом диапазоне (от 0 до значения last.getPos()).
        //  1.Если позиция pos недопустима, метод выбрасывает исключение (Результат неопределен, если p нет в списке или p=END(L) (выбросить исключение))
        //3. Если позиция допустима, метод возвращает новый объект Position с позицией, на 1 меньше чем у текущей позиции p.
        int pos = p.getPos();
        if (pos < 0 || pos >= last.getPos())
            throw new NoSuchElementException("Нет следующий позициию.");

        return new Position(p.getPos() + 1);
    }

    //возвращает предыдущую перед p позицию в списке L
    public Position Previous(Position p) {
        //1. Получаем позицию pos из объекта p.
        //2. Затем проверка, что позиция pos находится в допустимом диапазоне (от 1 до значения last.getPos()).
        //  1.Если позиция pos недопустима, метод выбрасывает исключение (Результат неопределен, если p = 1, p = END(L) или позиции p нет в списке L (выбросить исключение).)
        //Если позиция допустима, метод возвращает новый объект Position с позицией, на 1 больше чем у текущей позиции p.
        int pos = p.getPos();
        if (pos <= 0 || pos >= last.getPos())
            throw new NoSuchElementException("Нет предыдущей позиции.");

        return new Position(p.getPos() - 1);
    }

    public Position First() {
        //возвращает новый объект класса Position с начальным значением 0
        return new Position(0);
    }

    //возвращает позицию после последнего
    public Position End(){
        return last;
    }
    //делает список пустым
    public void MakeNull() {
        //1. Задаем переменной last 0 значение через setPos(), переносим ссылку на первый элемент, чтобы потом перезаписывать значения
         last.setPos(0);
    }
    //вывод списка на печать в порядке расположения элементов в списке
    public void PrintList() {
        System.out.println("Массив: ");
        for (int i = 0; i < last.getPos(); i++){
            System.out.print("Name: " + containers[i].NameToString()+ "   Adress: " + containers[i].AddressToString());
            System.out.println();
        }
        System.out.println();
    }
}
