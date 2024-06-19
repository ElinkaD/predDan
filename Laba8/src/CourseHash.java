public class CourseHash {
    // Список курсов организован с использованием закрытого хеширования
    private CourseHashElement[] array; // в качестве словаря двумерный массив
    private final static int SIZE = 3;  //Фиксированный размер словаря

    public CourseHash(){ //Выделяю память под массив
        array = new CourseHashElement[SIZE];
    }

    public void INSERT(int name) {
        int counter = 0; // Инициализируем счетчик
        int deleted = -1; // Инициализируем очищенную ячейку

        int index = hashFunc(name, 0);
        int start_index = index;        //Запоминаем начальный хэш

        index = hashFunc(name, ++counter);

        if(array[index] == null){
            array[index] = new CourseHashElement(name, null);
            return;
        }

        //Бесконечный цикл нужно еще проверить что он не входит повторно туда куда не надо !!!!
        while (index != start_index){
            if (deleted == -1 && array[index].course == 0){
                deleted = index; // Потенциальное место для вставки, если есть уделенный элемент
            }

            else index = hashFunc(name, counter++);
        }

        // Если дошли до конца и нашли удаленный элемент
        if (deleted != -1) {
            array[deleted].course = name;
            return;
        }

        // Нашли пустую ячейку - вставляем туда
        if (array[index] == null) {
            array[index] = new CourseHashElement(name,null);
        }
    }

    //1. Ищу элемент с именем name с помощью метода find()
    //2. Если результат find() не равен -1 (элемент найден) завершаю метод
    //3. Если элемент найден, удаляю его, присваивая первому символу массива по найденному индексу значение null
    public void DELETE(int name) {
        int temp = find(name);
        if (temp != -1){
            array[temp].course = 0;
        }
    }

    //возвращает true, если name принадлежит array, и значение false, если name не принадлежит array
    //Выполем метод find, он возращает либо индекс либо -1 в случае отсутствия элемента в массиве
    //Поэтому сравниваю результат функции с -1 и вывожу результат
    public CourseHashElement MEMBER(int name) {
        int i = find(name);
        return i >= 0 ? array[i] : null;
    }

    //Вывод словаря
    public void print() {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i].course + " ");
        }
        System.out.println();
    }

    // Хэш-функция
    //Возвращаем остаток от деления i на длину массива
    private int hashFunc(int hcode, int counter) { // Хеш-функция
        return (hcode + counter) % SIZE;
    }

    //Метод find() ищет элемент с именем name в словаре, возвращая его индекс, если он найден, или -1, если нет
    private int find(int name) {
        int index = hashFunc(name, 0); // Определяем индекс по значению хеш-функции (i=0)
        int start_index = index;

        int counter = 0;
        index = hashFunc(name, ++counter);

        // Находим новые индексы повторным линейным хешированием. Если имя совпадет с данным, возвращаем индекс,
        // если индекс станет равным первоначальному или элемента с таким индексом не будет существовать, то возвращаем -1
        while (array[index] != null || index != start_index){
            if (array[index].course == name) {
                return index;
            }
            index = hashFunc(name, ++counter);
        }
        return -1;
    }
}