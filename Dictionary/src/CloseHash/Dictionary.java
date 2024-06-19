package CloseHash;

public class Dictionary {

    private Element[] array; // в качестве словаря двумерный массив
    private final static int SIZE = 10;  //Фиксированный размер словаря

    public Dictionary(){ //Выделяю память под массив
        array = new Element[SIZE];
    }

    private class Element {
        private char[] name;

        public Element() {
            this.name = new char[10];
        }

        private Element(char[] n) {
            name = n;
        }

        // Сравнение имен
        public boolean EqualsName(char[] n) {
            // Если длины не совпадают
            if (name.length != n.length) {
                return false;
            }
            // Посимвольно сравниваем каждый символ двух имен и возвращаем false в случае неравенства символов
            for (int i = 0; i < n.length; i++) {
                if (name[i] != n[i]) {
                    return false;
                }
            }
            return true;
        }

        // Метод для проверки элемента на удаление
        public boolean IsItDeleted() {
            return name[0] == '\u0000';
        }
    }

    public void INSERT(char[] name) {
        int counter = 0; // Инициализируем счетчик

        int deleted = -1; // Инициализируем очищенную ячейку

        // Вычисляем начальный хэш
        int hcode = hashCode(name);
        int index = hashFunc(hcode, counter);

        //Запоминаем начальный хэш
        int start_index = index;

        if(array[index] == null){
            array[index] = new Element(name);
            return;
        }

        //Бесконечный цикл нужно еще проверить что он не входит повторно туда куда не надо !!!!
        while (array[index] != null){
            counter++;
            if (array[index].EqualsName(name)){ // Избежание повторов
                return;
            }

            if (deleted == -1 && array[index].IsItDeleted()){
                deleted = index; // Потенциальное место для вставки, если есть уделенный элемент
            }

            //следующий хэш
            index = hashFunc(hcode, counter);

            //Если мы вернулись на стартовый хэш -> выходим из цикла
            if(index == start_index){
                break;
            }
        }

        // Если дошли до конца и нашли удаленный элемент
        if (deleted != -1) {
            array[deleted].name = name;
            return;
        }

        // Нашли пустую ячейку - вставляем туда
        if (array[index] == null) {
            array[index] = new Element(name);
        }
    }

    //1. Ищу элемент с именем name с помощью метода find()
    //2. Если результат find() не равен -1 (элемент найден) завершаю метод
    //3. Если элемент найден, удаляю его, присваивая первому символу массива по найденному индексу значение null
    public void DELETE(char[] name) {
        int temp = find(name);
        if (temp != -1){
            array[temp].name[0] = '\u0000';
        }
    }

    //возвращает true, если name принадлежит array, и значение false, если name не принадлежит array
    //Выполем метод find, он возращает либо индекс либо -1 в случае отсутствия элемента в массиве
    //Поэтому сравниваю результат функции с -1 и вывожу результат
    public boolean MEMBER(char[] name) {
        int i = find(name);
        return i != -1;
    }

    //присваивает множеству array значение пустого множества
    //1. Прохожу по всем элементам массива и присваиваю им null
    public void MAKENULL(){
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
    }

    //Вывод словаря
    public void print() {
        for (Element element : array) { // Вывод всех элементов словаря
            if (element != null && !element.IsItDeleted()) {
                printName(element.name);
            }
        }
    }

    // Хэш-функция
    //Возвращаем остаток от деления i на длину массива
    private int hashFunc(int hcode, int counter) { // Хеш-функция
        return (hcode + counter) % SIZE;
    }

    //Находим сумму всех символов имени
    private int hashCode(char[] name){
        int sum = 0;
        for (char c : name) {
            sum += c;
        }
        return sum;
    }

    //Метод find() ищет элемент с именем name в словаре, возвращая его индекс, если он найден, или -1, если нет
    //1. Суммирую ASCII-коды всех символов в имени name, чтобы получить хэш-код
    //2. Вычисляю начальный индекс с помощью хеш-функции, используя hcode

    //3. Проверяю, существует ли элемент по индексу start и не удален ли он, а также совпадает ли имя с name
    // Если да - возвращаю true

    //4. Поиск других индексов
    //Если начальный индекс не совпадает, начинаю линейное пробирование, вычисляя новый индекс (index = hashFunc(hcode + counter)
    //Цикл продолжается, пока не найду совпадение имени или не пройду весь массив. При этом я следую циклически от конца массива к началу, используя hashFunc(hcode + counter) для получения нового индекса

    //5. Если нахожу элемент с тем же именем, возвращаю его индекс
    // Если не нахожу совпадений или индексы замкнулись, возвращаю -1
    private int find(char []name) {
        int hcode = hashCode(name);
        int start = hashFunc(hcode, 0); // Определяем индекс по значению хеш-функции (i=0)

        if (array[start] != null && array[start].IsItDeleted() && array[start].EqualsName(name)) return start;

        int counter = 1;
        int index = hashFunc(hcode, counter);
        counter++;
        // Находим новые индексы повторным линейным хешированием. Если имя совпадет с данным, возвращаем индекс,
        // если индекс станет равным первоначальному или элемента с таким индексом не будет существовать, то возвращаем -1
        while (array[index] != null || index != start){
            if (array[index] != null && array[index].EqualsName(name)) {
                return index;
            }
            index = hashFunc(hcode, counter);
            counter++;
        }
        return -1;
    }

    private void printName(char[] name){ // Вывод массива имени
        if (name == null) return; // Если имя пустое или удаленное, выводить нечего
        if (name[0] == '\u0000') return;

        int counter = 0;
        for (int i = 0; i < name.length; i++){ // Посимвольно выводим имя
            if (name[i] != '\u0000'){
                System.out.print(name[i]);
            }
            else counter ++;
        }
        if (counter != 10) System.out.println();
    }
}