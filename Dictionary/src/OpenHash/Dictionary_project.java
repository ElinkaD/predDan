package OpenHash;
/*
public class Dictionary_project {
    private static class element{ // Элемент словаря
        char[] name;
        element next; // Следующий элемент

        // Конструктор элемента - задает пустые значение
        public element(){
            name = null;
            next = null;
        }
        // Копирующий конструктор
        public element(char[] n, element next){
            this.next = next;
            name = new char[10]; //выделяем память
            //Перекопируем символы имени в name в цикле
        }

        public void setName(char[] n){
            //Если имя n пустое, тогда name приравниваем к null
            //Иначе перекопируем новое имя в цикле
        }

        //вывод имени
        public void printName(){
        }
    }

    private element array[]; //Список имён
    private final int SIZE = 10; //Фиксированный размер имени

    //Конструктор
    public Dictionary(int b){
        // Выделение памяти под массив в новую переменную
        // В цикле выделяем память для каждого нового элемента нового списка
    }

    //делает name элементом множества array
    public void INSERT(char[] name) {
        //1. Вычисляю индекс index для вставки, используя хеш-функцию hashFunction(name)
        //2. Если элемент по индексу index не существует, создаю новый элемент с именем name и добавляю его

        //3. Если элемент по индексу index существует, проверяю его по списку для поиска совпадающего имени
            //1. Если нахожу элемент с тем же именем, прекращаю выполнение, чтобы избежать дублирования

        //4. Если совпадений не найдено, создаю новый элемент с переданным именем и вставляю его в конец списка
    }

    //удаляет элемент name из множества array
    public void DELETE(char[] name) {
        // Определяю индекс index для удаления, используя хеш-функцию hashFunction(name)
        //1. Если элемент по индексу index отсутствует, возвращаюсь, так как нечего удалять

        //2. Если name совпадает с array[index].name
            //1. Проверяю является ли это последним элементом да - просто обнуляю элемент нет - присваиваю данные следующего элемента

        //3. Если имена не совпадают, ищу предыдущий элемент с именем name с помощью findPrev()

        //4. Если предыдущий элемент найден и есть следующий элемент, удаляю элемент, перенаправляя ссылки
    }

    //возвращает true, если name принадлежит array, и значение false, если name не принадлежит array
    public boolean MEMBER(char[] name) {
        //1. Определяю индекс index для проверки, используя хеш-функцию hashFunction(name)
        //2. Проверяю, равны ли name и array[index].name с помощью метода compareArray()
        //3. Если имена не равны, ищу предыдущий элемент с именем name с помощью findPrev()
        //4. Возвращаю true, если имя найдено, или false, если нет
    }

    //Хэш функция
    private int hashFunction(char[] name){
        //1. Начинаю с переменной sum, равной нулю
        //2. Прохожу по всем символам в массиве name и добавляю их значения к sum
        //3. Возвращаю остаток от деления sum на длину массива array, чтобы получить индекс для массива
    }


    //присваивает множеству array значение пустого множества
    public void MAKENULL(){
        //1. Прохожу по всем элементам массива
        //2. Устанавливаю методом setName() значение null для каждого имени name и для ссылки next каждого элемента массива.
    }

    //вывод словаря
    public void print(){
        //используем метод вывода имени printName() + вывод если элемент не пустой
    }

    //Приватный метод для поиска предыдущего элемента в списке
    private element findPrev(char[] name, int index){
        //1. Создаем переменный для предыдущего и текущего значения
        //2. Пока текущее значение не равно null
            //1. Сравниваем имя текущего элемента с переданным символьным массивом name с помощью метода compareArray().
            //2. Перенос ссылок на следующие элементы по порядку
        //3. Иначе возвращаем null
    }

    //Метод для посимвольного сравнения двух символьных массивов
    private boolean compareArray(char[] a, char[] b){
        //Используем цикл, если хотя бы одни элементы неравны вывод false, иначе true
    }
}


*/
/*
package OpenHash;

public class Dictionary {
    private final int length = 10;//Число элементов массива
    private Element [] array;     //Массив

    private class Element {//Элемент списка
        private char [] name;//Имя хранящееся в словаре
        private Element next;//Следующий элемент

        private Element() {}

        //Конструктор на передаваемом имени
        private Element(char[] name) {
            this.name = new char[10];
            setName(name);
        }

        //Конструктор на передаваемом имени и следующем значении
        private Element(char[] name, Element next) {
            this.name = new char[10];
            setName(name);
            this.next = next;
        }

        //Метод копирует передаваемое имя в имя этого элемента
        private void setName(char[] name) {
            int i;
            //1. Присваем каждый элемент передаваемого массива соответсвующему элементу этого массива
            for (i = 0; i < name.length; i++)
                this.name[i]=name[i];
            //2. Тепер если мы вставили < 10 элементов то встаавляем в конец метку нуля
            if (i != 10) {
                this.name[i] = '\0';
            }
        }
        public void printName(){
            if (name == null) return; // Если имя не пустое, выводим, пока не встретим 0
            int counter = 0;
            for (int i = 0; i < name.length; i++){
                if (name[i] != '\u0000'){
                    System.out.print(name[i]);
                }
                else counter ++;
            }
            if (counter != 10) System.out.println();
        }

        //Метод проверяет равенство передаваемого name и установленного name в этом элементе
        private boolean equals (char [] name) {
            //1. Если мы имеем ссылку на один и тот же массив, то возвращаем true;
            if (this.name == name) return true;
            //2. Если длина передоваемого массива > 10, то очевидно возвращаем false
            if (name.length > 10) return false;
            //3. Проходимся по каждому элементу двух массивов (до конца передаваемого массива)
            for (int i = 0; i < name.length; i++) {
                //4. Если у обоих массивов мы в один и тот же момент дошли до метки нуля то возвращаем true
                if (name[i]=='\0' && this.name[i]=='\0') return true;
                //5. Если мы нашли различие в двух массивах то возвращаем false;
                if (name[i] != this.name[i]) return false;
            }
            //6. Теперь если длина передаваемого массива == 10, значит возвращаем true (массивы имеют одинаковую длину и мы дошли до ее конца)
            if (name.length==10) return true;
            //7. Если нет, то необходимо сравнить следующий элемент у массива хранящегося в этом объекте на равенству метки нуля
            return this.name[name.length]=='\0';
        }
    }

    //Хэш-функция
    private int hashFunction(char [] name) {
        //Считаем сумму charов и находим остаток от деления на длину массива
        int sum = 0;
        for (int i = 0; i < name.length; i++)
            sum += name[i];
        return sum % length;
    }
    //Функция возвращает предыдущее значение от заданного (передаем индекс массива, в котором находится список, в котором мы осуществляем поиск)
    private Element getPreThis (char [] element, int index) {
        //1. Определяем переменные с помощью которых будем проходится по элементам списка
        Element preRunning = null;
        Element running = array [index];
        //2. Пока не дойдем до конца
        while (running != null) {
            //3. Если найдем эквивалентность элиментов, то следует вернуть предыдущий элемент
            if (running.equals(element))
                return preRunning;
            //4. В противном случае переходим к следующим элементам списка
            preRunning = running;
            running = running.next;
        }
        //5. Если ничего не нашли, то возвращаем null
        return null;
    }

    //Конструктор
    public Dictionary(){
        array = new Element[length];
    }

    //Делает словарь пустым
    public void MAKENULL() {
        //1. Проходимся по каждому элементу массива и зануляем его
        for (int i = 0; i < length; i++) {
            array[i]=null;
        }
    }

    //Есть ли заданный элемент в словаре
    public boolean MEMBER(char [] name) {
        //1. Получаем хэш
        int hash = hashFunction(name);
        //2. Если имя находится в голове одного из списков
        if (array[hash] == null) return false;
        if (array[hash].equals(name)) return true;
        //3. Получим предыдущее значение и сравним его с null
        if (getPreThis(name, hash) == null) return false;
        return true;
    }

    //Вставка в словарь
    public void INSERT(char [] name) {
        //1. С помощью hashFunction определяем индекс элемента массива, в котором находится спискок, в который мы будем вставлять
        int index = hashFunction (name);
        //2. Если head этого списка == null, то вставляем в голову
        Element running = array [index];
        if (running == null) {
            array[index] = new Element (name);
            return;
        }
        //3. В противном случае проходимся по каждому элементу списка, пока не дойдем до конца (попутно проверяем, может быть
        // заданный элемент уже есть в списке
        Element preRunning = null;
        while (running!=null) {
            if (running.equals(name)) return;
            preRunning = running;
            running = running.next;
        }
        //4. Устанавливаем следующее значение элемента списка
        preRunning.next = new Element (name);
    }

    //Удаление из словаря
    public void DELETE(char [] name) {
        //1. Получаем хэш
        int hash = hashFunction(name);
        if (array[hash] == null) return;
        //2. Если имя находится в голове одного из списков
        if (array[hash].equals(name)) {
            array[hash] = array[hash].next;
            return;
        }
        //3. Получаем предыдущий элемент от заданного
        Element previous = getPreThis(name, hash);
        //4. Если он == null, то удалять нечего
        if (previous == null) return;
        //5. Связываем предыдущий элемент и следующий
        previous.next = previous.next.next;
    }
    //вывод словаря
    public void print() {
        for (int i = 0; i < array.length; i++) { // Вывод каждого элемента массива, если он существует
            Element x = array[i];
            while (x != null) {
                x.printName();
                x = x.next;
            }
        }
    }
}
 */
/*
package openHash;


public class Map
{
    public final int MAX_CLASS_COUNT = 5; // Максимальное кол-во классов

    private Item[] _array; // Массив

    // Инициализирующий конструктор
    public Map()
    {
        _array = new Item[MAX_CLASS_COUNT];
    }

    // Находится ли в множестве name
    public boolean Member(char[] name)
    {
        // Получаем хэш
        int hash = HashFunc(name);

        // Если по этому хэшу ничего нет, то false
        if(_array[hash] == null)
        {
            return false;
        }

        // Если в корне лежит необходимое значение, то true
        if(EqualsCharArrays(_array[hash].Name, name))
        {
            return true;
        }

        // Возвращаем предыдущее значение
        Item prevItem = GetPrevItem(hash, name);

        // Если нет его, то false, если есть, то true
        if(prevItem == null)
        {
            return false;
        }

        return prevItem.Next != null;
    }

    // Обнуление множества
    public void MakeNull()
    {
        for(int i = 0; i < MAX_CLASS_COUNT; i++)
        {
            _array[i] = null;
        }
    }

    // Вставка эл-та в множество
    public void Insert(char[] name)
    {
        // Вычисляем хэш
        int hash = HashFunc(name);

        // Если по этому хэшу пусто, то создаем эл-т, елы палы
        if(_array[hash] == null)
        {
            _array[hash] = new Item(name, null);
            return;
        }

        // Получаем предыдущий
        Item prevItem = GetPrevItem(hash, name);

        // Если корректный следующий эл-т, то return
        if(prevItem != null && EqualsCharArrays(prevItem.Next.Name, name))
        {
            return;
        }

        // Вставляем эл-т
        _array[hash] = new Item(name, _array[hash]);
    }

    // Удаляем эл-т из множества
    public void Delete(char[] name)
    {
        // Считаем хэш
        int hash = HashFunc(name);

        // Если по этому хэшу пусто, то создаем эл-т, елы палы
        if(_array[hash] == null)
        {
            return;
        }

        // Проверяем голову
        if(EqualsCharArrays(_array[hash].Name, name))
        {
            _array[hash] = _array[hash].Next;
            return;
        }

        // Получаем предыдущий
        Item prevItem = GetPrevItem(hash, name);

        // Если предыдущий null, то return
        if(prevItem == null)
        {
            return;
        }

        // Проверяем след эл-т
        if(EqualsCharArrays(prevItem.Next.Name, name))
        {
            prevItem.Next = prevItem.Next.Next;
        }
    }

    public void Print()
    {
        for(int i = 0; i < _array.length; i++)
        {
            if(_array[i] == null)
            {
                System.out.println(i + ". null");
            }
            else {
                String res = "";

                Item current = _array[i];
                while (current != null)
                {
                    res += new String(current.Name) + ", ";
                    current = current.Next;
                }

                System.out.println(i + ". " + res);
            }
        }
    }

    // Хэширующая функция
    private int HashFunc(char[] string)
    {
        int sum = 0;
        for(char symbol : string)
        {
            sum += symbol;
        }

        return sum % MAX_CLASS_COUNT;
    }

    // Проверка на совпадение символьных массивов
    private boolean EqualsCharArrays(char[] a, char[] b)
    {
        if(a.length != b.length)
        {
            return false;
        }

        for(int i = 0; i < a.length; i++)
        {
            if(a[i] != b[i])
            {
                return false;
            }
        }

        return true;
    }

    // Ищем эл-та по массиву a и возвращаем предыдущий
    private Item GetPrevItem(int hash, char[] a)
    {
        Item prevItem = null;
        Item currentItem = _array[hash];

        while (currentItem != null)
        {
            if(EqualsCharArrays(currentItem.Name, a))
            {
                return prevItem;
            }

            prevItem = currentItem;
            currentItem = currentItem.Next;
        }

        return null;
    }
}
*/
