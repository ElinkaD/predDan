package OpenHash;

public class Dictionary {
    private final int SIZE = 10;//Число элементов массива
    private Element [] array;     //Массив

    private class Element {//Элемент списка
        private char [] name;//Имя хранящееся в словаре
        private Element next;//Следующий элемент

        //Конструктор
        private Element(char[] name, Element next) {
            this.name = new char[SIZE];
            setName(name);
            this.next = next;
        }

        //Копируем передаваемое имя в имя этого элемента
        private void setName(char[] name) {
            int i;
            //1. Присваем каждый элемент передаваемого массива соответсвующему элементу этого массива
            for (i = 0; i < name.length; i++)
                this.name[i]=name[i];
            //2. Тепер если мы вставили < 10 элементов то встаавляем в конец метку нуля
            if (i != 10) {
                this.name[i] = '\u0000';
            }
        }
        // сравнение имён
        private boolean equals(char[] a){
            for (int i = 0; i < name.length && name[i] != '\u0000'; i++){
                if (name[i] != a[i])
                    return false;
            }
            return true;
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
    }
    //Конструктор
    public Dictionary(){
        array = new Element[SIZE];
    }

    //присваивает множеству array значение пустого множества
    public void MAKENULL() {
        for (int i = 0; i < SIZE; i++) {
            array[i] = null;
        }
    }

    //Результат есть ли элемент в словаре
    public boolean MEMBER(char [] name) {
        int hash = hashFunc(name); // Определяем индекс с помощью hash-функции

        if (array[hash].equals(name)) return true; // Если имена равны, возвращаем true

        return (findPrev(name, hash) != null); // Иначе, если найдется предыдущий, возвращаем true, иначе false
    }

    //Вставка в словарь
    public void INSERT(char [] name) {
        int hash = hashFunc(name); // Определяем индекс, куда будет производится insert с помощью hashFunc(name)

        if (array[hash] == null) { // Если имя с этим индексом пустое, присваеваем name в голову
            array[hash] = new Element(name, null);
            return;
        }

        //Ищем предыдущий
        Element prev = findPrev(name, hash);

        //Если все верно, а точнее след элемент - возврат return
        if(prev != null && prev.next.equals(name)) {
            return;
        }

        //Вставка элемента
        array[hash] = new Element(name, array[hash]);
    }

    //Удаление из словаря
    public void DELETE(char [] name) {
        int hash = hashFunc(name);  // Определяем индекс с помощью hash-функции
        if (array[hash] == null) return; // Если в этом месте ничего нет, ничего удалять не нужно

        if (array[hash].equals(name)) { // Если имя существует в голове одного из списков
            array[hash] = array[hash].next;
            return;
        }
        // Если на найденном месте не то имя, то просто ищем предыдущий элемент
        Element prev = findPrev(name, hash);
        if (prev == null) return;
        // Проверяем след эл-т
        if(prev.next.equals(name)) {
            prev.next = prev.next.next;
        }
    }

    //Хэш-функция
    private int hashFunc(char [] name) {
        int sum = 0;
        for (int i = 0; i < name.length; i++) // Находим сумму элементов массива имени и возвращаем ее остаток от
            // деления на длину массива array
            sum += name[i];
        return sum % SIZE;
    }
    //Функция возвращает предыдущее значение от заданного (передаем индекс массива, в котором находится список, в котором мы осуществляем поиск)
    private Element findPrev (char [] element, int index) {
        Element prev = null;
        Element temp = array [index];
        while (temp != null) { // Идем указателем по некстам, если имя следующего элемента совпало с искомым
            // возвращаем указатель
            if (temp.equals(element))
                return prev;
            //переход к след элементам
            prev = temp;
            temp = temp.next;
        }
        //ничего не нашли возвращаем null
        return null;
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