public class StudentHash {
    // Список студентов организован с использованием закрытого хеширования
    private StudentHashElement[] array; // в качестве словаря двумерный массив
    private final static int SIZE = 10;  //Фиксированный размер словаря

    public StudentHash(){ //Выделяю память под массив
        array = new StudentHashElement[SIZE];
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
            array[index] = new StudentHashElement(name, null);
            return;
        }

        //Бесконечный цикл нужно еще проверить что он не входит повторно туда куда не надо !!!!
        while (array[index] != null){
            counter++;
            if (array[index].equals(name)){ // Избежание повторов
                return;
            }

            if (deleted == -1 && array[index].isDeleted()){
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
            array[deleted].studentName = name;
            return;
        }

        // Нашли пустую ячейку - вставляем туда
        if (array[index] == null) {
            array[index] = new StudentHashElement(name, null);
        }
    }

    //1. Ищу элемент с именем name с помощью метода find()
    //2. Если результат find() не равен -1 (элемент найден) завершаю метод
    //3. Если элемент найден, удаляю его, присваивая первому символу массива по найденному индексу значение null
    public void DELETE(char[] name) {
        int temp = find(name);
        if (temp != -1){
            array[temp].studentName[0] = '\0';
        }
    }

    //возвращает true, если name принадлежит array, и значение false, если name не принадлежит array
    //Выполем метод find, он возращает либо индекс либо -1 в случае отсутствия элемента в массиве
    //Поэтому сравниваю результат функции с -1 и вывожу результат
    public StudentHashElement MEMBER(char[] name) {
        int res = find(name);
        if (res != -1)
            return array[res];
        return null;
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
    private int find(char []name) {
        int hcode = hashCode(name);
        int start = hashFunc(hcode, 0); // Определяем индекс по значению хеш-функции (i=0)

        if (array[start] != null && array[start].isDeleted() && array[start].equals(name)) return start;

        int counter = 1;
        int index = hashFunc(hcode, counter);
        counter++;
        // Находим новые индексы повторным линейным хешированием. Если имя совпадет с данным, возвращаем индекс,
        // если индекс станет равным первоначальному или элемента с таким индексом не будет существовать, то возвращаем -1
        while (array[index] != null || index != start){
            if (array[index] != null && array[index].equals(name)) {
                return index;
            }
            index = hashFunc(hcode, counter);
            counter++;
        }
        return -1;
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
        for (int i = 0; i < array.length; i++){
            if (array[i] != null) {
                array[i].printName();
            }
        }
    }

}

