package Сircle;
/*
public class Set_project {

    //Класс элемента множества
    private static class Node {
        private int value; //значение элемента множества
        private Node next; //следующий элемент множества

        //Конструктор
        private Node(int v, Node n) { //Инициализация переменных value и next
            value = v;
            next = n;
        }
    }

    public Node tail;// последний элемент множества

    public Set_project(){
        tail = null;
    }
    public Set_project(Node tail) {this.tail = tail;}

    //Принадлежность значения х множеству
    public boolean MEMBER(int x){
        //1. Если множество пустое (хвост равен null) – вернуть false
        //2. Ищем предыдущий элемент findPrev() и записываем в переменную temp
        //3. Эту переменную проверяем на null и равенство след элемента с x
        //4. Если temp не прошла проверки возвращаем false
    }

    //вспомогательный метод для поиска предыдущего findPrev
    private Node findPrev(int x){
        //1. Если след элемент равен х(голова) – возвращаем tail
        // prev = null, temp = tail.next
        //2. Проходим по циклу пока переменная temp, хранящая голову, не станет равна tail
        //  1. Если значение temp, будет больше или равно х, возвращаем запаздывающую переменную prev
        //  2. Иначе меняем значения prev и temp на следующие за ними элементы
        //3. Не найдя ничего возвращаем null
    }

    public Set_project FIND(Set_project B, int x){
        //1. Находим переменную x методом findPrev и записываем ее в temp
        //2. Проверяем текущее множество и элемент на пустоту (tail, temp), то оно принадлежит текущему множеству
        //3. Ищем переменную x методом findPrev в множестве В и записываем ее в temp
        //4. Проводим ту же проверку, и в случае true возвращаем множество В
        //5. Если элемента нет ни в одном из множеств, возвращаем null
    }

    public Set_project UNION(Set_project B){
        //1. Если текущее множество пустое(tail == null) - возвращаем множество B
        //2. Аналогично смотрим множество В - возврат текущего
        //3. Возвращаем результат работы функции AorB
    }

    public Set_project INTERSECTION(Set_project B){
        //1. Если текущее множество пустое(tail == null) и множество В пустое - возвращаем null
        //2. Сравниваем текущее множество и мн-во В - возвращаем текущее
        //3. Возвращаем результат работы функции AinB
    }

    public Set_project DIFFERENCE(Set_project B){
        //1. Если текущее множество пустое(tail == null) - возвращаем множество B
        //2. Аналогично смотрим множество В - возврат текущего
        //3. Сравниваем текущее множество и мн-во В - возвращаем null
        //4. Возвращаем результат работы функции AsubB
    }

    public Set_project MERGE(Set_project B){
        //1. Если текущее множество пустое(tail == null) и множество В пустое - возвращаем null
        //2. Если множества пересекаются, возвращаем пустое множество
        //3. Возвращаем результат работы функции AorB
    }

    private Set_project AinB(Node B){
        //1. Инициализация нового узла tailC для формирования дополнительного мн-ва С
        //2. Установка временных указателей tempA и tempB на начало множеств A и B

        //Добавление элементов из A или B в множество С
        //3. Пока не достигнуто окончание хотя бы в одном из множеств
        //      1. Если значение в A меньше, перейти к следующему элементу в A
        //      2. Если значение в A больше, перейти к следующему элементу в B
        //      3. Если значения равны, добавить соответствующий элемент в множество C, и перейти к следующим элементам в обоих множествах
        //4. Связывание последнего элемента с началом, чтобы обеспечить цикличность нового множества C.
        //5. Возвращаем новое множество C
    }

    private Set_project AorB(Node B){
        //1. Инициализация нового узла tailC для формирования дополнительного мн-ва С
        //2. Установка временных указателей tempA и tempB на начало множеств A и B

        //Добавление элементов из A или B в множество С
        //3. Пока не достигнуто окончание хотя бы в одном из множеств
        //      1. Если значение в A меньше, перейти к следующему элементу в A
        //      2. Если значение в A больше, перейти к следующему элементу в B
        //      3. Если значения равны, добавить соответствующий элемент в множество C, и перейти к следующим элементам в обоих множествах
        //4. Связывание последнего элемента с началом, чтобы обеспечить цикличность нового множества C
        //5. Если одно из множеств оказалось незавершенным, докопировать его в множество C
        //6. Возвращаем новое множество C
    }

    private Set_project AsubB(Node B){
        //1. Инициализация нового узла tailC для формирования дополнительного мн-ва С
        //2. Установка временных указателей tempA и tempB на начало множеств A и B

        //Добавление элементов из A или B в множество С
        //3. Пока не достигнуто окончание хотя бы в одном из множеств
        //      1. Если значение в A меньше, добавляем его в C и переходим к следующему в A
        //      2. Если значение в A больше, переходим к следующему элементу в B.
        //      3. Если значения равны, переходим к следующим элементам в обоих множествах.
        //4. Вставка элемента в множество C и обновление tailC и headC.

        //5. Проверка оставшихся элементов
        //   1. Если достигнут конец множества A, проверяем оставшиеся элементы в B
        //      Добавляем оставшиеся элементы из B в C, учитывая возможную разницу в длине множеств
        //   2. Если достигнут конец множества B, проверяем оставшиеся элементы в A
        //      Добавляем оставшиеся элементы из A в C, учитывая возможную разницу в длине множеств

        //5. Связывание последнего элемента с началом, чтобы обеспечить цикличность нового множества C
        //6. Добавление оставшихся элементов, если множество A не закончилось
        //7. Возвращаем новое множество C
    }


    public void MakeNull(){
        // tail равен null
    }

    public void INSERT(int x){
        //1. Если множество пустое
        //  1. Создаем новый узел tail со значением x, и связывается сам с собой

        //2. Если в множестве 1 элемент
        //  1. Если новое значение равно текущему, операция завершается
        //  2. Если x больше текущего значения в tail, то вставляем его в конец
        //  3. Если x меньше текущего значения в tail, то вставляем его перед текущим tail

        //3. Если x меньше значения, следующего за tail(головы)

        //4. Общий случай:
        //  1. Ищем предыдущий методом findPrev(x)`
        //  2. Если такового нет, вставляем узел после tail
        //  3. Если уже есть узел с таким значением, операция завершается
        //  4. Иначе, осуществляется вставка x в нужное место после найденного узла
    }



    public void DELETE(int x){
        // 4 случая
        //1. Если список пустой
        //2. Если удаляем из хвоста
        //  1. Если в множестве не один элемент tail = tail.next
        //  2. Если в множестве 1 элемент tail = null
        //3. Иначе - общий случай
        //  1. Ищем предыдущий, проверяем есть ли он и перекидываем ссылки
    }

    public void ASSIGN(Set_project B){
        //1. Проверяем, являются ли текущее множество и множество B одинаковыми. Если да, то метод завершается.

        //2. Если множество B пустое, текущему множеству присваивается значение `null`, и метод завершается.

        //3. Перенос элементов из множества B в текущее множество
        //   1. Создаем новый узел tail для текущего множества
        //   2. Создаем временные указатели tempA и tempB, где tempA - конец текущего мн-ва

        //4. В цикле копируем значения из В в А поэлементно, создавая новые узлы
        //           Указатели переходят к следующим элементам в обоих множествах

        //5. Последний элемент текущего множества связывается с началом
    }

    public int MIN(){
        //1. Если множество пустое - ошибка
        //2. Возвращаем значение головы tail.next
    }

    public int MAX(){
        //1. Если множество пустое - ошибка
        //2. Возвращаем значение хвоста tail
    }

    public boolean EQUAL(Set_project B){
        //1. Если оба множества пусты - true
        //2. Если одно из множеств пустое - false

        //3. Сравнение множеств с одним элементом
        //  1. Если в каждом мн-ве только по одному элементу, то они равны только, если эти элементы равны
        //  2. Если в одном из множеств только 1 элемент, то они не могут быть равными - возврат false

        //4. В цикле поэлементно сравниваем эл-ты из множеств, в случае если они различны - возврат false

        //5. Если все элементы совпали и указатели достигли конца множеств, возвращается true, иначе false
    }


    public void print(){
        // Вывод на экран
    }
}
 */

/*
package Сircle;

public class Set {

    //Класс элемента множества
    private static class Atom
    {
        private int value; //значение элемента множества
        private Atom next; //следующий элемент множества

        //Конструктор
        private Atom(int v, Atom n)
        {
            value = v;//Инициализация переменных value и next
            next = n;
        }
    }

    public Atom tail;// последний элемент множества

    public Set(){
        tail = null;
    }
    public Set(Atom tail) {this.tail = tail;}

    //Пренадлежность значеия х множеству
    //1. Если множество пустое (хвост равен null) – вернуть false
    //2. Ищем предыдущий элемент findPrev() и записываем в переменную temp
    //3. Эту переменную проверяем на null и равенство след элемента с x
    //4. Если temp не прошла проверки возвращаем false
    public boolean MEMBER(int x){
        if (tail == null) return false;
        Atom temp = findPrev(x);
        if (temp != null && temp.next.value == x) return true;
        return false;
    }

    //1. Если текущее множество пустое(tail == null) - возвращаем множество B
    //2. Аналогично смотрим множество В - возврат текущего
    //3. Возвращаем результат работы функции AorB
    public Set Union(Set B){
        if (tail == null) return B; // Если А пустое - возвращаем В
        if (B.tail == null) return this; // Если В пустое - возвращаем А
        return AorB(B.tail); // Возвращаем результат работы метода AorB (приватный метод, эквивалентный Union)
    }

    //1. Если текущее множество пустое(tail == null) и множество В пустое - возвращаем null
    //2. Сравниваем текущее множество и мн-во В - возвращаем текущее
    //3. Возвращаем результат работы функции AinB
    public Set Intersection(Set B){
        if (tail==null || B.tail==null) return null; // Если А или В пустое, возвращаем пустое множество
        if (this.equal(B)) return this;// Если А и В равны, возвращаем А
        return AinB(B.tail);// Возвращаем результат работы метода AinB (приватный метод, эквивалентный Intersection)
    }

    //1. Если текущее множество пустое(tail == null) - возвращаем множество B
    //2. Аналогично смотрим множество В - возврат текущего
    //3. Сравниваем текущее множество и мн-во В - возвращаем null
    //4. Возвращаем результат работы функции AsubB
    public Set Difference(Set B){
        if (tail==null) return B;// Если А пустое, возвращаем В
        if (B.tail == null) return this; // Если В пустое - возвращаем А
        if (this.equal(B)) return null;// Если А и В равны, возвращаем пустое множество
        return AsubB(B.tail);// Возвращаем результат работы метода AsubB (приватный метод, эквивалентный Difference)

    }

    //1. Если текущее множество пустое(tail == null) и множество В пустое - возвращаем null
    //2. Если множества пересекаются, возвращаем пустое множество
    //3. Возвращаем результат работы функции AorB
    public Set Merge(Set B){
        if (tail==null || B.tail==null) return null;// Если А или В пустое, возвращаем пустое множество
        if (AinB(B.tail) != null) return null;// Если множества пересекаются, возвращаем пустое множество
        return AorB(B.tail); // Возвращаем результат работы метода AorB (приватный метод, эквивалентный Union)
    }


    public void MakeNull(){
        tail = null;
    } // tail равен null

    //1. Если множество пустое
    //  1. Создаем новый узел tail со значением x, и связывается сам с собой

    //2. Если в множестве 1 элемент
    //  1. Если новое значение равно текущему, операция завершается
    //  2. Если x больше текущего значения в tail, то вставляем его в конец
    //  3. Если x меньше текущего значения в tail, то вставляем его перед текущим tail

    //3. Если x меньше значения, следующего за tail(головы)

    //4. Общий случай:
    //  1. Ищем предыдущий методом findPrev(x)`
    //  2. Если такового нет, вставляем узел после tail
    //  3. Если уже есть узел с таким значением, операция завершается
    //  4. Иначе, осуществляется вставка x в нужное место после найденного узла
    public void Insert(int x){
        if (tail == null){ // Если множество пустое, определяем первый и последний элемент одним "Атомом"
            tail = new Atom(x, null);
            tail.next = tail;
        }
        //return вместо else !!!!!!
        //без случая с одним эелементов
        //меньше меньшего - вставка перед головой без getPrev()!!!!!!
        //больше большего - вставка после хвоста
        else if (tail.next == tail){ // Если в множестве 1 элемент
            if (x == tail.value) return; // Если это тот же элемент
            else if (x > tail.value){ // Если этот элемент больше тейла, то вставляем его в конец
                tail.next = new Atom(tail.value, tail);
                tail.value = x;
            }
            else tail.next = new Atom(x, tail); // Если элемент меньше тейла, вставляем в начало
        }
        else if (x < tail.next.value) {
            tail.next = new Atom(x, tail.next);
        }
        else { // Общий случай
            Atom temp = findPrev(x);
            if (temp == null) {
                tail.next = new Atom(x, tail.next);// Если число больше всех в списке, вставляем после хвоста
                tail = tail.next;
            }
            else if (temp.next.value == x) return;
            else { //Вставляем в найденное место
                Atom temporary = temp.next;
                temp.next = new Atom(x, temporary);}

        }
    }

    // 4 случая
    //1. Если список пустой
    //2. Если удаляем из хвоста
    //3. Когда удаленное значение < меньшего и > большего  !!!!!!! - просто return
    //4. Иначе - общий случай
    //  1. Ищем предыдущий, проверяем есть ли он и перекидываем ссылки
    public void Delete(int x){
        if (tail == null) return; //Если множество пустое
        if (x == tail.value) { // Если нужно удалить элемент из хвоста
            tail = null;
        }

        else { //Общий случай
            Atom temp = findPrev(x); // Ищем предыдущий элемент, если его нет, то и удалять нечего
            Atom temp2 = null;
            if (temp!= null) {
                temp2 = temp.next;
                if (temp.next.value == x) temp.next = temp.next.next;
            }
        }
    }

    //1. Проверяем, являются ли текущее множество и множество B одинаковыми. Если да, то метод завершается.

    //2. Если множество B пустое, текущему множеству присваивается значение `null`, и метод завершается.

    //3. Перенос элементов из множества B в текущее множество
    //   1. Создаем новый узел tail для текущего множества
    //   2. Создаем временные указатели tempA и tempB, где tempA - конец текущего мн-ва

    //4. В цикле копируем значения из В в А поэлементно, создавая новые узлы
    //           Указатели переходят к следующим элементам в обоих множествах

    //5. Последний элемент текущего множества связывается с началом
    public void Assign(Set B){
        if (this == B) return;
        if (B.tail == null) { // Если новое множество пустое
            tail = null;
            return;
        }

        // Иначе
        tail = new Atom(B.tail.value, null); //Переопределяем хвост
        Atom tempA = tail; // Создаем два указателя и переопределяем В в А поэлементно
        Atom tempB = B.tail.next;

        while (tempB != B.tail){
            tempA.next = new Atom(tempB.value, null);
            tempA = tempA.next;
            tempB = tempB.next;
        }

        tempA.next = tail;
    }

    //1. Если множество пустое - ошибка
    //2. Возвращаем значение головы tail.next
    public int Min(){
        if (tail == null) throw new RuntimeException("Set is empty"); //Если множество пустое, выводим ошибку
        return tail.next.value; // Возвращаем значение головы, так как множество упорядоченное
    }

    //1. Если множество пустое - ошибка
    //2. Возвращаем значение хвоста tail
    public int Max(){
        if (tail == null) throw new RuntimeException("Set is empty"); //Если множество пустое, выводим ошибку
        return tail.value; // Возвращаем значение хвоста, так как множество упорядоченное
    }

    //1. Если оба множества пусты - true
    //2. Если одно из множеств пустое - false

    //3. Сравнение множеств с одним элементом
    //  1. Если в каждом мн-ве только по одному элементу, то они равны только, если эти элементы равны
    //  2. Если в одном из множеств только 1 элемент, то они не могут быть равными - возврат false

    //4. В цикле поэлементно сравниваем эл-ты из множеств, в случае если они различны - возврат false

    //5. Если все элементы совпали и указатели достигли конца множеств, возвращается true, иначе false
    public boolean Equal(Set B){
        return this.equal(B); // Вызов приватной функции, так как сравнение также нужно в некоторых других методах
    }

    private boolean equal(Set b) {
        if (tail == null && b.tail==null) return true; // Если оба множества пустые, они равны
        if (tail == null || b.tail==null) return false; // Если одно из множеств пустое, они не могут быть пустыми
        if (tail.next==tail && b.tail.next==b.tail) return (tail.value==b.tail.value); // Если в каждом из множеств по одному элементу, то они равны, только если эти элементы равны
        if (tail.next==tail || b.tail.next==b.tail) return false; // Если только в одном множестве 1 элемент, они не могут быть равны
        Atom tempA = tail.next; // Берем два указателя и сравниваем множества поэлементно
        Atom tempB = b.tail.next;

        while (tempB != b.tail && tempA != tail){
            if (tempA.value != tempB.value) return false;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if (tempA != tail || tempB != b.tail) return false;
        return true;
    }

    //1. Находим переменную x методом findPrev и записываем ее в temp
    //2. Проверяем текущее множество и элемент на пустоту (tail, temp), то оно принадлежит текущему множеству
    //3. Ищем переменную x методом findPrev в множестве В и записываем ее в temp
    //4. Проводим ту же проверку, и в случае true возвращаем множество В
    //5. Если элемента нет ни в одном из множеств, возвращаем null
    public Set Find(Set B, int x){
        Atom temp = findPrev(x);
        if (tail != null && temp != null && temp.next.value==x ) return this; // Если первое множество не пустое
        // и элемент равен значению головы или можно найти предыдущий элемент, то он принадлежит первому множеству
        temp = B.findPrev(x);
        if (B.tail!= null && temp != null && temp.next.value==x ) return B; // Та же проверка для второго множества
        return null; // Если элемента нет ни в одном из множеств, возвращаем null
    }

    private void copyRest(Atom from, Atom b){
        Atom tailC = this.tail;
        while (from != b){
            if (tailC == null) { // Вставляем в С
                tailC.value = from.value;
                tailC.next = tailC;
            }
            else {
                tailC.next = new Atom(from.value, tailC.next);
                tailC = tailC.next;
            }
            from = from.next;
        }
        if (tailC == null) { // Вставляем в С
            tailC.value = from.value;
            tailC.next = tailC;

        }
        else {
            tailC.next = new Atom(from.value, tailC.next);
            tailC = tailC.next;
        }
    }
    //1. Инициализация нового узла tailC для формирования дополнительного мн-ва С
    //2. Установка временных указателей tempA и tempB на начало множеств A и B

    //Добавление элементов из A или B в множество С
    //3. Пока не достигнуто окончание хотя бы в одном из множеств
    //      1. Если значение в A меньше, перейти к следующему элементу в A
    //      2. Если значение в A больше, перейти к следующему элементу в B
    //      3. Если значения равны, добавить соответствующий элемент в множество C, и перейти к следующим элементам в обоих множествах
    //4. Связывание последнего элемента с началом, чтобы обеспечить цикличность нового множества C.
    //5. Возвращаем новое множество C
    private Set AinB(Atom B){
        Atom tailC = null; // Создаем дополнительное множество С
        Atom tempA = this.tail.next; // Одновременно идем двумя указателями по А и В:
        Atom tempB = B.next;
        Atom newAtom = null;
        Atom headC = null;
        while (tempA != this.tail && tempB != B){ // проверяем до tail
            if (tempA.value < tempB.value) tempA = tempA.next; //Если элемент А меньше элемента В, то идем к следующему в А.
            if (tempA.value > tempB.value) tempB = tempB.next; //Если элемент А больше элемента В, то идем к следующему в В.
            if (tempA.value == tempB.value) { //Если элементы равны, добавляем соответствующий элемент в С.
                newAtom = new Atom(tempA.value, null);
                tempA = tempA.next;
                tempB = tempB.next;
            }

            if (tailC == null) { // Вставляем в С
                tailC = newAtom;
                headC = tailC;
            }
            else {
                tailC.next= newAtom;
                tailC = tailC.next;
            }
        }
        if (tempA == this.tail){
            while (tempB != B.next){ // теперь проверяем до head
                if (tempA.value < tempB.value) break; //Если элемент А меньше элемента В, то идем к следующему в А.
                if (tempA.value > tempB.value) tempB = tempB.next; //Если элемент А больше элемента В, то идем к следующему в В.
                if (tempA.value == tempB.value) { //Если элементы равны, добавляем соответствующий элемент в С.
                    if (tailC == null) { // Вставляем в С
                        tailC = new Atom(tempA.value, null);
                        headC = tailC;
                    }
                    else {
                        tailC.next= new Atom(tempA.value, null);
                        tailC = tailC.next;
                    }
                    break;
                }
            }
        }
        else if (tempB == B){
            while (tempA != this.tail.next){ // теперь проверяем до head
                if (tempA.value < tempB.value) tempA = tempA.next; //Если элемент А меньше элемента В, то идем к следующему в А.
                if (tempA.value > tempB.value) break; //Если элемент А больше элемента В, то идем к следующему в В.
                if (tempA.value == tempB.value) { //Если элементы равны, добавляем соответствующий элемент в С.
                    newAtom = new Atom(tempA.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    break;
                }
            }
        }
        // Так как мы проверяли до конца, в одном из множеств может остаться последний элемент, так что нужна еще одна проверка
        tailC.next = headC;
        return new Set(tailC); // возвращаем новое множество
    }

    //1. Инициализация нового узла tailC для формирования дополнительного мн-ва С
    //2. Установка временных указателей tempA и tempB на начало множеств A и B

    //Добавление элементов из A или B в множество С
    //3. Пока не достигнуто окончание хотя бы в одном из множеств
    //      1. Если значение в A меньше, перейти к следующему элементу в A
    //      2. Если значение в A больше, перейти к следующему элементу в B
    //      3. Если значения равны, добавить соответствующий элемент в множество C, и перейти к следующим элементам в обоих множествах
    //4. Связывание последнего элемента с началом, чтобы обеспечить цикличность нового множества C
    //5. Если одно из множеств оказалось незавершенным, докопировать его в множество C
    //6. Возвращаем новое множество C
    private Set AorB(Atom B){
        Atom tailC = null; // Создаем дополнительное множество С
        Atom tempA = this.tail.next; // Одновременно идем двумя указателями по А и В:
        Atom tempB = B.next;
        Atom newAtom = null;
        Atom headC = null;
        while (tempA != this.tail && tempB != B){ // проверяем до tail
            if (tempA.value < tempB.value) { //Если элемент А меньше элемента В, то добавляем из А и идем к следующему в А.
                newAtom = new Atom(tempA.value, null);
                tempA = tempA.next;
            }
            if (tempA.value > tempB.value) { //Если элемент А больше элемента В, то добавляем из В и идем к следующему в В.
                newAtom = new Atom(tempB.value, null);
                tempB = tempB.next;
            }
            if (tempA.value == tempB.value) { //Если элементы равны, добавляем соответствующий элемент в С.
                newAtom = new Atom(tempA.value, null);
                tempA = tempA.next;
                tempB = tempB.next;
            }
            if (tailC == null) { // Вставляем в С
                tailC = newAtom;
                headC = tailC;
            }
            else {
                tailC.next= newAtom;
                tailC = tailC.next;
            }
        }
        if (tempA == this.tail){
            while (tempB != B.next){ // теперь проверяем до head
                if (tempA.value < tempB.value) { //Если элемент А меньше элемента В, то добавляем из А и идем к следующему в А.
                    newAtom = new Atom(tempA.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    break;
                }
                if (tempA.value > tempB.value) { //Если элемент А больше элемента В, то добавляем из В и идем к следующему в В.
                    newAtom = new Atom(tempB.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    tempB = tempB.next;
                }
                if (tempA.value == tempB.value) { //Если элементы равны, добавляем соответствующий элемент в С.
                    newAtom = new Atom(tempA.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    tempB = tempB.next;
                    break;
                }
            }
        }
        else if (tempB == B){
            while (tempA != this.tail.next ){ // теперь проверяем до head
                if (tempA.value < tempB.value) { //Если элемент А меньше элемента В, то добавляем из А и идем к следующему в А.
                    newAtom = new Atom(tempA.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    tempA = tempA.next;
                }
                if (tempA.value > tempB.value) { //Если элемент А больше элемента В, то добавляем из В и идем к следующему в В.
                    newAtom = new Atom(tempB.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    break;
                }
                if (tempA.value == tempB.value) { //Если элементы равны, добавляем соответствующий элемент в С.
                    newAtom = new Atom(tempA.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    tempA = tempA.next;
                    break;
                }
            }
        }
        // Так как мы проверяли до конца, в одном из множеств может остаться последний элемент, так что нужна еще одна проверка
        tailC.next = headC;
        Set C = new Set(tailC);
        if (tempA == tail && tempB != tail) C.copyRest(tempB, B); // Если одно из множеств оказалось незаконченным, докопируем его в С
        else if (tempA != tail && tempB == tail) C.copyRest(tempA, this.tail);
        return C; // возвращаем новое множество
    }

    //1. Инициализация нового узла tailC для формирования дополнительного мн-ва С
    //2. Установка временных указателей tempA и tempB на начало множеств A и B

    //Добавление элементов из A или B в множество С
    //3. Пока не достигнуто окончание хотя бы в одном из множеств
    //      1. Если значение в A меньше, добавляем его в C и переходим к следующему в A
    //      2. Если значение в A больше, переходим к следующему элементу в B.
    //      3. Если значения равны, переходим к следующим элементам в обоих множествах.
    //4. Вставка элемента в множество C и обновление tailC и headC.

    //5. Проверка оставшихся элементов
    //   1. Если достигнут конец множества A, проверяем оставшиеся элементы в B
    //      Добавляем оставшиеся элементы из B в C, учитывая возможную разницу в длине множеств
    //   2. Если достигнут конец множества B, проверяем оставшиеся элементы в A
    //      Добавляем оставшиеся элементы из A в C, учитывая возможную разницу в длине множеств

    //5. Связывание последнего элемента с началом, чтобы обеспечить цикличность нового множества C
    //6. Добавление оставшихся элементов, если множество A не закончилось
    //7. Возвращаем новое множество C
    private Set AsubB(Atom B){
        Atom tailC = null; // Создаем дополнительное множество С
        Atom tempA = this.tail.next; // Одновременно идем двумя указателями по А и В:
        Atom tempB = B.next;
        Atom newAtom = null;
        Atom headC = null;
        while (tempA != this.tail && tempB != B){ // проверяем до tail
            if (tempA.value < tempB.value) { //Если элемент А меньше элемента В, то добавляем из А и идем к следующему в А.
                newAtom = new Atom(tempA.value, null);
                tempA = tempA.next;
            }
            if (tempA.value > tempB.value) {
                tempB = tempB.next; //Если элемент А больше элемента В, то идем к следующему в В.
            }
            if (tempA.value == tempB.value) {
                //Если элементы равны, идем к следующим одновременно
                tempA = tempA.next;
                tempB = tempB.next;
            }
            if (tailC == null) { // Вставляем в С
                tailC = newAtom;
                headC = tailC;
            }
            else {
                tailC.next= newAtom;
                tailC = tailC.next;
            }
        }
        if (tempA == this.tail){
            while ( tempB != B.next){ // теперь проверяем до head
                if (tempA.value < tempB.value) { //Если элемент А меньше элемента В, то добавляем из А и идем к следующему в А.
                    newAtom = new Atom(tempA.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    break;
                }
                if (tempA.value > tempB.value) {
                    tempB = tempB.next; //Если элемент А больше элемента В, то идем к следующему в В.
                }
                if (tempA.value == tempB.value) {
                    //Если элементы равны, идем к следующим одновременно
                    tempB = tempB.next;
                    break;
                }

            }
        }
        else if (tempB==B){
            while (tempA != this.tail.next){ // теперь проверяем до head
                if (tempA.value < tempB.value) { //Если элемент А меньше элемента В, то добавляем из А и идем к следующему в А.
                    newAtom = new Atom(tempA.value, null);
                    if (tailC == null) { // Вставляем в С
                        tailC = newAtom;
                        headC = tailC;
                    }
                    else {
                        tailC.next= newAtom;
                        tailC = tailC.next;
                    }
                    tempA = tempA.next;
                }
                if (tempA.value > tempB.value) {
                    break; //Если элемент А больше элемента В, то идем к следующему в В.
                }
                if (tempA.value == tempB.value) {
                    //Если элементы равны, идем к следующим одновременно
                    tempA = tempA.next;
                    break;
                }
            }
        }
        tailC.next = headC;
        Set C = new Set(tailC);
        if (tempA != tail && tempB == tail) C.copyRest(tempA, this.tail); // Если А не закончилось, докопируем его в С
        return C; // возвращаем новое множество

    }

    //вспомогательный метод для поиска предыдущего findPrev
    //1. Если след элемент равен х(голова) – возвращаем tail
    // prev = null, temp = tail.next
    //2. Проходим по циклу пока переменная temp, хранящая голову, не станет равна tail
    //  1. Если значение temp, будет больше или равно х, возвращаем запаздывающую переменную prev
    //  2. Иначе меняем значения prev и temp на следующие за ними элементы
    //3. Не найдя ничего возвращаем null
    private Atom findPrev(int x){
        if (tail.next.value == x) return tail; // Если х равен значению head, возвращаем tail
        Atom temp = null;               // проходим по циклу с запаздывающим указателем, возвращаем место, после которого нужно вставить
        Atom temp2 = tail.next;

        while (temp2 != tail){
            if (temp2.value >= x)
                return temp;

            temp = temp2;
            temp2 = temp2.next;
        }
        if (temp2.value == x) return temp;
        return null;
    }

    public void print(){ // Вывод на экран
        if (tail == null) return;
        Atom temp = tail.next;
        while (temp != tail && temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        System.out.print(tail.value + " ");
        System.out.println();
    }
}
*/