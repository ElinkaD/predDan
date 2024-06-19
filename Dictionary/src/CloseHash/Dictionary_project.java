package CloseHash;
/*
public class Dictionary_project {

    private char[][] array; // в качестве словаря двумерный массив
    private final static int SIZE = 10; //Фиксированный размер словаря
    private int size = 0; //Текущий размер словаря

    //Конструктор
    public Dictionary(int b){
        //Выделяю память под массив
    }

    public void INSERT(char[] name) {
        //1. Если словарь заполнен size == SIZE, выбрасываю исключение, так как не могу вставить новое имя
        //2. Вычисляю хэш-код имени name с помощью функции hashCode()
        // определяю начальный индекс для вставки с помощью хеш-функции hashFunc()

        //3. Сохраняю начальный индекс в переменную number
        //   Создаю переменную count для счета повторного хэширования
        //   Создаю переменную del для индекса первой удаленной записи

        //4. Начинаю проверку индексов с начала в цикле(пока не найду пустую позицию)
        //  1. Сравниваю name и array[index] если равны выхожу из цикла(избежание повторов)
        //  2. Если del = -1 и место array[index] свободно (проверка с помощью функции isDeleted()) - приравниваю к del index(потенциальное место для вставки)
        //  3. Иначе - если индекс уже занят, метод использует повторным линейное хэшированием для поиска следующего доступного слота для вставки нового имени.

        //5. Когда нахожу пустое место или удаленное место (del != 1), вставляю новое имя(функцией copyArray())
        //   и увеличиваю размер словаря size+
    }

    public void DELETE(char[] name) {
        //1. Ищу элемент с именем name с помощью метода find()
        //2. Если результат find() не равен -1 (элемент найден) завершаю метод
        //3. Если элемент найден, удаляю его, присваивая первому символу массива по найденному индексу значение null
        // + уменьшаю размер словаря size--
    }


    //возвращает true, если name принадлежит array, и значение false, если name не принадлежит array
    public boolean MEMBER(char[] name) {
        //Выполем метод find, он возращает либо индекс либо -1 в случае отсутствия элемента в массиве
        //Поэтому сравниваю результат функции с -1 и вывожу результат
    }


    //присваивает множеству array значение пустого множества
    public void MAKENULL() {
        //1. Прохожу по всем элементам массива и присваиваю им null
    }

    //Вывод словаря
    public void print() {
        //Выводим с помощью метода printName() каждый элемент массива
    }

    // Хэш-функция
    private int hashFunc(int i) {
        //Возвращаем остаток от деления i на длину массива
    }

    //Находим сумму всех символов имени
    private int hashCode(char[] name){
        //1. Объявляем переменную sum
        //2. В цикле суммируем все элементы массива имени в переменную sum
        //3. Возвращаем sum
    }

    //Метод find() ищет элемент с именем name в словаре, возвращая его индекс, если он найден, или -1, если нет
    private int find(char []name) {
        //1. Суммирую ASCII-коды всех символов в имени name, чтобы получить хэш-код
        //2. Вычисляю начальный индекс с помощью хеш-функции, используя hcode

        //3. Проверяю, существует ли элемент по индексу start и не удален ли он (isDeleted), а также совпадает ли имя с name
        // Если да - возвращаю true

        //4. Поиск других индексов
            //Если начальный индекс не совпадает, начинаю линейное пробирование, вычисляя новый индекс (index = hashFunc(hcode + counter)
            //Цикл продолжается, пока не найду совпадение имени или не пройду весь массив. При этом я следую циклически от конца массива к началу, используя hashFunc(hcode + counter) для получения нового индекса

        //5. Если нахожу элемент с тем же именем, возвращаю его индекс
        // Если не нахожу совпадений или индексы замкнулись, возвращаю -1
    }


    //Приватный метод для копирования масивов
    private void copyArray(char[] from, char[] to){
        //Посимвольно копируем элементы из одного массива во второй
    }

    //Метод для посимвольного сравнения двух символьных массивов
    private boolean compareArray(char[] a, char[] b){
        //Используем цикл, если хотя бы одни элементы неравны вывод false, иначе true
    }

    private boolean isDeleted(char[] a){
        // Возвращаю результат сравнения элемента с null
    }

    //вывод имени
    private void printName(char[] name){
    }
}


































package CloseHash;
public class Dictionary {

    private Element[] array;
    private final int length = 10;

    private class Element {
        private boolean isDeleted;
        private char[] name;

        private Element() {
        }

        //Конструктор на передаваемом имени
        private Element(char[] name) {
            this.name = new char[10];
            setName(name);
            isDeleted = false;
        }

        //Метод копирует передаваемое имя в имя этого элемента
        private void setName(char[] name) {
            int i;
            //1. Присваем каждый элемент передаваемого массива соответсвующему элементу этого массива
            for (i = 0; i < name.length; i++)
                this.name[i] = name[i];
            //2. Тепер если мы вставили < 10 элементов то встаавляем в конец метку нуля
            if (i != 10) {
                this.name[i] = '\0';
            }
        }

        //Метод проверяет равенство передаваемого name и установленного name в этом элементе
        private boolean equals(char[] name) {
            //1. Если мы имеем ссылку на один и тот же массив, то возвращаем true;
            if (this.name == name) return true;
            //2. Если длина передоваемого массива > 10, то очевидно возвращаем false
            if (name.length > 10) return false;
            //3. Проходимся по каждому элементу двух массивов (до конца передаваемого массива)
            for (int i = 0; i < name.length; i++) {
                //4. Если у обоих массивов мы в один и тот же момент дошли до метки нуля то возвращаем true
                if (name[i] == '\0' && this.name[i] == '\0') return true;
                //5. Если мы нашли различие в двух массивах то возвращаем false;
                if (name[i] != this.name[i]) return false;
            }
            //6. Теперь если длина передаваемого массива == 10, значит возвращаем true (массивы имеют одинаковую длину и мы дошли до ее конца)
            if (name.length == 10) return true;
            //7. Если нет, то необходимо сравнить следующий элемент у массива хранящегося в этом объекте на равенству метки нуля
            return this.name[name.length] == '\0';
        }

    }

    public Dictionary() {
        array = new Element[length];
    }

    //Хэш-функция
    private int hashFunction(int hash, int iteration) {
        return (hash + iteration) % length;//Именно так
    }

    //хэш
    private int hash(char[] name) {
        int sum = 0;
        for (int i = 0; i < name.length; i++) sum += name[i];
        return sum;
    }

    private int find(char[] name) {
        //1. Считаем hash переданного name
        int hash = hash(name);
        int oldHash = hashFunction(hash, 0);
        if (array[oldHash] == null) return -1;
        if (array[oldHash].equals(name)) return oldHash;
        //2. И следующий за ним
        int newHash = hashFunction(hash, 1);
        //3. Пока newHash != oldHash (не пройдем все элементы)
        int iteration = 2;
        while (newHash != oldHash) {
            //4. Если дошли до null, значит name не может быть в списке и возвращаем -1
            if (array[newHash] == null) return -1;
            //5. Проверяем экивалентность имен, если они эквивалентны то возвращаем newHash
            if ((array[newHash].equals(name))) return newHash;
            //6. Увеличиваем newHash
            newHash = hashFunction(hash, iteration);
            iteration++;
        }
        //8. Если дошли до сюда значит ничего не нашли и возвращаем -1
        return -1;
    }

    public void insert(char[] name) {
        //1. Вычисляем хэш
        int hash = hash(name);
        int oldHash = hashFunction(hash, 0);
        //2. Если в позиции хэша ничего нет вставляем новый элемент
        if (array[oldHash] == null) {
            array[oldHash] = new Element(name);
            return;
        }

        //3. Если в позиции хэша элемент удален просто обновим у элемента поля
        if (array[oldHash].isDeleted) {
            //установим что оно больше не удалено
            array[oldHash].isDeleted = false;
            //установим новое имя
            array[oldHash].setName(name);
            return;
        }

        if (array[oldHash].equals(name))
            return;//Если элементы имеют одно и тоже имя, то мы вставляем одинаковые элементы и в этом нет смысла

        //4. Посчитаем новый хэш
        int newHash = hashFunction(hash, 1);
        //5. И установим счетчик, чтобы знать на какой по счету итерации хэширования мы находимя
        int iteration = 2;
        //6. Теперь пока мы не проверим свободность всех элементов массива (не вернемся к начальному элементу)
        while (newHash != oldHash) {
            //7. Здесь мы проверяем, если элемента нет, то можно его вставить и return
            if (array[newHash] == null) {
                array[newHash] = new Element(name);
                return;
            }
            //8. А если он удален то обновим поля и return
            if (array[newHash].isDeleted) {
                array[newHash].isDeleted = false;
                array[oldHash].setName(name);
                return;
            }
            if (array[newHash].equals(name))
                return;//Если элементы имеют одно и тоже имя, то мы вставляем одинаковые элементы и в этом нет смысла
            //9. Считаем новый hash и увеличиваем counter
            newHash = hashFunction(hash, iteration);
            iteration++;
        }
    }

    public void delete(char[] name) {
        //1. Ищем с помощью метода find индекс в котором находится заданный name
        int i = find(name);
        //2. Если он был найдет (find не вернул -1), то устанавливаем isDeleted = true
        if (i != -1) array[i].isDeleted = true;
    }

    public boolean member(char[] name) {
        //Проверяем с помощью метода find
        int i = find(name);
        return i != -1 && array[i].isDeleted == false;
    }

    public void makeNull() {
        //Каждый элемент массива = null
        for (int i = 0; i < array.length; i++) array[i] = null;
    }
}
*/
