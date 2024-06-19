public class PartOrderedSet {

    //Используется для связывания элементов множества в цепочку
    private class Bond {
        protected setElement id; // Ссылка на следующий элемент в списке
        protected Bond next; // Ссылка на следующий элемент типа Bond

        // Конструктор для создания нового элемента типа Bond
        public Bond(setElement i, Bond n){
            id = i;
            next = n;
        }
    }

    //Представление элемента множества - эл-нт связного списка
    private class setElement extends Bond {
        protected int key; // Значение элемента
        protected int count; // Количество предшественников

        // Конструктор для создания нового элемента типа setElement
        public setElement(setElement i, Bond n, int k, int c) {
            super(i, n);
            key = k;
            count = c;
        }
    }

    private setElement head; // Голова

    // Конструктор пустого множества
    public PartOrderedSet() {
        head = null;
    }

    // Метод для инициализации множества
    public boolean init(int[][] array){
        if (array.length == 0 || array[0][0] >= array[0][1]) // Проверка корректности массива
            return false;

        head = new setElement(null,null, array[0][0], 0); // Создание головы
        head.id = new setElement(null, null, array[0][1], 0); // Инициализация id и next для головы
        head.next = new Bond(head.id,null); // Установка следующего элемента для головы
        head.id.count++; // Увеличение счетчика предшественников

        for (int i = 1; i < array.length; i++) {
            setElement temp1;
            setElement temp2;

            int a = array[i][0];
            int b = array[i][1];

            if (a == b){ // Проверка корректности пары значений
                return false;
            }

            temp1 = find(a); // Поиск места для первого значения
            if (temp1.key != a) { // Создание нового элемента, если его нет
                temp1.id = new setElement(null, null, a, 0);
                temp1 = temp1.id;
            }

            temp2 = find(b); // Поиск места для второго значения
            if (temp2.key != b){ // Создание нового элемента, если его нет
                temp2.id = new setElement(null, null, b, 0);
                temp2 = temp2.id;
            }

            temp2.count++; // Увеличение счетчика предшественников

            Bond tempBond = temp1.next; // Получение следующего элемента в списке
            temp1.next = new Bond(temp2, tempBond); // Установка нового элемента после первого значения

        }
        return true; // Успешная инициализация
    }


    // Метод для сортировки множества
    public boolean sort() {
        PartOrderedSet newSet = new PartOrderedSet(); // Создание нового множества для сортировки
        setElement temp = head;
        setElement prevTemp = null;
        setElement lastInNewSet = null;
        while (temp != null) {
            prevTemp =findNull(temp);

            if (prevTemp==null) temp = head;
            else temp = prevTemp.id;
            if (temp == null) return false;

            deletePred(temp); // Удаление предшественников

            setElement temporary = temp;
            //Перенос головы
            if (temp == head) {
                head = head.id; // Удаление узла без предшественников
            } else {
                prevTemp.id = temp.id; // Удаление узла с предшественниками
            }

            // Если список полный
            if (newSet.head != null) {
                setElement t = lastInNewSet.id;
                lastInNewSet.id = temporary;
                lastInNewSet.id.id = t;
                lastInNewSet = lastInNewSet.id; // Сохранение последнего элемента в новом множестве
            } else {
                newSet.head = temporary; // Установка головы для нового множества
                newSet.head.id = null;
                lastInNewSet = newSet.head;
            }
            temp = head; // Поиск следующего узла без предшественников
        }
        print(); // Вывод множества на экран
        System.out.println();
        head = newSet.head; // Установка новой головы
        return true;
    }

    // Приватный метод для поиска узла без предшественников
    private setElement findNull(setElement t){
        setElement prev = null;
        while (t != null) {
            if (t.count == 0) return prev; // Возврат предыдущего узла, если текущий без предшественников
            else{
                prev = t;
                t = t.id;
            }
        }
        return null;
    }
    // Приватный метод для поиска элемента по ключу
    private setElement find(int p) {
        setElement temp = head;
        setElement temp2 = null;

        while (temp != null){ // Поиск элемента с заданным ключом
            if (p == temp.key) {
                return temp; // Возврат элемента, если ключ найден
            }
            temp2 = temp;
            temp = temp.id; // Переход к следующему элементу
        }
        return temp2; // Возврат последнего элемента, если ключ не найден
    }

    // Приватный метод для удаления предшественников
    private void deletePred(setElement temp) {
        Bond tempBond = temp.next; // Получение следующего элемента в списке

        while (tempBond != null){ // Удаление каждого предшественника
            tempBond.id.count--; // Уменьшение счетчика предшественников
            tempBond = tempBond.next;
        }

        temp.next = null; // Установка следующего элемента в null
    }



    // Метод для вывода множества на экран
    public void print() {
        setElement temp = head;
        while (temp != null) {
            System.out.print("Элемент: " + temp.key  + " | Предшественники: ");
            Bond tempT = temp.next;
            while (tempT != null) {
                System.out.print(tempT.id.key+ " "); // Вывод элементов списка
                tempT = tempT.next;
            }
            System.out.println(); // Переход на новую строку для следующего элемента множества
            temp = temp.id; // Переход к следующему элементу
        }
    }
}