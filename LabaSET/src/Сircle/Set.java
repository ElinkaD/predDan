package Сircle;

public class Set {

    public class Item {
        public int value; //значение элемента множества
        public Item next; //следующий элемент множества

        public Item(int v, Item n) {
            value = v; //Инициализация переменных value и next
            next = n;
        }

        public Item(Item item) {
            value = item.value;
        }
    }

    private Item tail;

    // Инициализирующий конструктор
    public Set(int start, int end) {
        tail = null;
    }

    // Копирующий конструктор
    public Set(Set b) {
        if (b.tail == null) {
            tail = null;
            return;
        }
        copy(b, this);
    }


    // Метод вставки элемента в множество
    public void INSERT(int x) {
        // 1. Если список пустой
        if (tail == null) {
            tail = new Item(x, null);
            tail.next = tail;
            return;
        }
        // 2. Если элемент больше текущего хвоста, вставляем его в конец
        if (x > tail.value) {
            Item newTail = new Item(x, tail.next);
            tail.next = newTail;
            tail = newTail;
            return;
        }
        // 3. Если элемент меньше головы, вставляем его в начало
        if (x < tail.next.value) {
            Item newItem = new Item(x, tail.next);
            tail.next = newItem;
            return;
        }
        // 4. Иначе - общий случай
        // 4.1. Ищем место для вставки
        Item current = tail.next;
        while (current.next != tail.next && current.next.value < x) {
            current = current.next;
        }
        // 4.2. Вставляем элемент в середину
        Item newItem = new Item(x, current.next);
        current.next = newItem;
    }

    // Метод проверки принадлежности элемента множеству
    public boolean MEMBER(int x) {
        // 1. Если множество пустое
        if (tail == null) {
            return false;
        }
        // 2. Если элемент находится в хвосте
        if (tail.value == x) {
            return true;
        }
        // 3. Иначе ищем элемент в множестве
        Item current = tail.next;
        while (current != tail && current.value != x) {
            current = current.next;
        }
        // 4. Возвращаем результат поиска
        return current.value == x;
    }

    // Метод удаления элемента из множества
    public void DELETE(int x) {
        // 1. Если элемент вне диапазона, то return
        if (!in_diapason(x)) {
            return;
        }
        // 2. Ищем первый элемент меньший значения
        Item prevItem = findPrev(x);
        // 3. Если его нет, то return
        if (prevItem == null) {
            return;
        }
        // 4. Если есть, то проверяем равенство следующего со значением, если не равны то return
        if (prevItem.next.value != x) {
            return;
        }
        // 5. Если у нас один элемент в множестве, то обнуляем множество
        if (tail.next == tail) {
            tail = null;
            return;
        }
        // 6. Если удаляем последний элемент
        if (prevItem.next == tail) {
            Item temp = tail.next;
            tail = prevItem;
            prevItem.next = temp;
            return;
        }
        // 7. Если удаляем из середины
        prevItem.next = prevItem.next.next;
    }


    // Минимум
    public int MIN() {
        if (tail != null) {
            return tail.next.value;
        }
        throw new RuntimeException("Empty set");
    }

    // Максимум
    public int MAX() {
        if (tail != null) {
            return tail.value;
        }
        throw new RuntimeException("Empty set");
    }

    // Метод копирования множества b в текущее
    public void ASSIGN(Set b) {
        // 1. Если множество b равно null, то return
        if (b == null) {
            return;
        }
        // 2. Если множество b равно текущему множеству, то return
        if (b == this) {
            return;
        }
        // 3. Копируем множество b в текущее множество
        copy(b, this);
    }

    // Сравнивает два множества на равенство
    public boolean EQUAL(Set b) {
        // 1. Если множество b равно текущему множеству, то return true
        if (b == this) {
            return true;
        }
        // 2. Если множество b равно null, то return false
        if (b == null) {
            return false;
        }
        // 3. Если оба множества пусты
        if (b.tail == null) {
            return tail == null;
        }
        // 4. Сравниваем поэлементно
        Item aCurrentItem = tail.next;
        Item bCurrentItem = b.tail.next;

        while (aCurrentItem != tail && bCurrentItem != b.tail) {
            if (aCurrentItem.value != bCurrentItem.value) {
                return false;
            }
            aCurrentItem = aCurrentItem.next;
            bCurrentItem = bCurrentItem.next;
        }
        // 5. Сравниваем концы
        return tail.value == b.tail.value;
    }

    // Находит, в каком множестве находится элемент x
    public Set FIND(Set b, int x) {
        Set res = null;
        // 1. Ищем элемент x в текущем множестве с помощью findPrev
        Item first = findPrev(x);
        if (first != null && first.next.value == x) {
            res = this;
        }
        // 2. Ищем элемент x в множестве b с помощью findPrev
        first = b.findPrev(x);
        if (first != null && first.next.value == x) {
            if (res == null) {
                res = b;
            } else {
                res = null;
            }
        }
        // 3. Возвращаем результат
        return res;
    }


    // Объединяет непересекающиеся множества
    public Set MERGE(Set b) {
        // 1. Если множество b равно null или b равно текущему множеству, возвращаем копию b
        if (b == null || b == this) {
            return new Set(b);
        }
        // 2. Возвращаем объединенное множество
        return UnionSets(b);
    }

    // Обнуляет множество
    public void MAKE_NULL() {
        tail = null;
    }


    // Вывод на экран
    public void PRINT() {
        if (tail == null) {
            System.out.println("Empty set!");
            return;
        }
        Item currentItem = tail.next;
        String string = "";
        while (currentItem != tail) {
            string += currentItem.value + " ";
            currentItem = currentItem.next;
        }
        string += currentItem.value + " ";
        System.out.println(string);
    }

    // Пустое ли множество
    public boolean IS_EMPTY() {
        return tail == null;
    }

    // Метод возвращает пересечения множеств
    public Set INTERSECTION(Set b) {
        // 1. Если множество b равно null, текущее множество пусто или множество b пусто, возвращаем null
        if (b == null || tail == null || b.tail == null) {
            return null;
        }
        // 2. Если множество b равно текущему множеству, возвращаем копию b
        if (b == this) {
            return new Set(b);
        }
        return IntersectSets(b);
    }

    // Проверяет, пересекается ли текущее множество с множеством b
    public boolean IS_INTERSECT(Set b) {
        // 1. Создаем множество пересечения
        Set newSet = IntersectSets(b);
        // 2. Проверяем, не пусто ли пересечение
        return newSet.tail != null;
    }

    private Set IntersectSets(Set b) {
        // 1. Создаем новое множество на основе текущего
        Set newSet = new Set(this);

        Item prevNewListIndex = newSet.tail;
        Item newListIndex = newSet.tail.next;
        Item bListIndex = b.tail.next;

        // 2. Проходим по обоим множествам, пока не достигнем конца одного из них
        while (newListIndex != newSet.tail && bListIndex != b.tail) {
            if (newListIndex.value < bListIndex.value) {
                prevNewListIndex.next = prevNewListIndex.next;
                newListIndex = newListIndex.next;
            } else if (newListIndex.value > bListIndex.value) {
                bListIndex = bListIndex.next;
            } else {
                prevNewListIndex = newListIndex;
                newListIndex = prevNewListIndex.next;
                bListIndex = bListIndex.next;
            }
        }

        // 3. Проверяем последний элемент
        if (newListIndex.value == bListIndex.value) {
            return newSet;
        }

        // 4. Если достигли конца нового множества
        if (newListIndex == newSet.tail) {
            Item prevItem = findPrev(bListIndex, b.tail, newListIndex.value);
            if (prevItem == null || prevItem.next.value == newListIndex.value) {
                prevNewListIndex.next = newSet.tail.next;
                newSet.tail = prevNewListIndex;
                return newSet;
            }
            if (newSet.tail == newSet.tail.next) {
                newSet.tail = null;
                return newSet;
            }
            Item temp = newSet.tail.next;
            prevNewListIndex.next = temp;
            newSet.tail = prevNewListIndex;
            return newSet;
        }

        // 5. Если достигли начала нового множества
        if (newListIndex == newSet.tail.next) {
            Item prev = findPrev(newListIndex, newSet.tail, bListIndex.value);
            if (prev == null || prev.next.value != bListIndex.value) {
                newSet.tail = null;
                return newSet;
            }
            newSet.tail = prev.next;
            newSet.tail.next = prev.next;
            return newSet;
        }

        // 6. Завершаем пересечение
        Item temp = newSet.tail.next;
        prevNewListIndex.next = temp;
        newSet.tail = prevNewListIndex;
        return newSet;
    }


    // Метод объединения множеств
    public Set UNION(Set b) {
        // 1. Если множество b равно null или b равно текущему множеству, возвращаем копию b
        if (b == null || b == this) {
            return new Set(b);
        }
        return UnionSets(b);
    }

    private Set UnionSets(Set b) {
        // 1. Создаем копию текущего множества
        Set newSet = new Set(this);

        Item prevNewSetIndex = newSet.tail;
        Item newSetIndex = newSet.tail.next;
        Item bListIndex = b.tail.next;

        // 2. Объединяем множества до конца одного из них
        while (newSetIndex != newSet.tail && bListIndex != b.tail) {
            // 2.1. Если элемент newSet меньше, двигаем индекс newSet
            if (newSetIndex.value < bListIndex.value) {
                prevNewSetIndex = newSetIndex;
                newSetIndex = newSetIndex.next;
            }
            // 2.2. Если элемент b меньше, вставляем его в newSet и двигаем индекс b
            else if (newSetIndex.value > bListIndex.value) {
                Item temp = new Item(bListIndex.value, newSetIndex);
                prevNewSetIndex.next = temp;
                prevNewSetIndex = temp;
                bListIndex = bListIndex.next;
            }
            // 2.3. Если элементы равны, вставляем один и двигаем оба индекса
            else {
                bListIndex = bListIndex.next;
                prevNewSetIndex = newSetIndex;
                newSetIndex = newSetIndex.next;
            }
        }

        // 3. Если достигли конца newSet, добавляем оставшиеся элементы b
        if (newSetIndex == newSet.tail) {
            while (bListIndex != b.tail) {
                if (newSetIndex.value < bListIndex.value) {
                    Item temp = new Item(bListIndex.value, newSet.tail.next);
                    newSet.tail.next = temp;
                    newSet.tail = temp;
                    prevNewSetIndex = newSetIndex;
                    newSetIndex = temp;
                    bListIndex = bListIndex.next;
                } else if (newSetIndex.value > bListIndex.value) {
                    Item temp = new Item(bListIndex.value, newSetIndex);
                    prevNewSetIndex.next = temp;
                    prevNewSetIndex = temp;
                    bListIndex = bListIndex.next;
                } else {
                    bListIndex = bListIndex.next;
                }
            }
        }

        // 4. Если последний элемент равен, возвращаем объединенное множество
        if (newSetIndex.value == bListIndex.value) {
            return newSet;
        }

        // 5. Пытаемся вставить последний элемент b
        Item prev = findPrev(newSetIndex, newSet.tail, bListIndex.value);
        if (prev == null) {
            Item temp = new Item(bListIndex.value, newSet.tail.next);
            newSet.tail.next = temp;
            newSet.tail = temp;
            return newSet;
        }
        if (prev.next.value != bListIndex.value) {
            prev.next = new Item(bListIndex.value, prev.next);
        }
        return newSet;
    }


    // Метод возвращает разницу множеств
    public Set DIFFERENCE(Set b) {
        // 1. Если множество b равно null, возвращаем копию текущего множества
        if (b == null) {
            return new Set(this);
        }
        // 2. Если множество b равно текущему множеству, возвращаем null
        if (b == this) {
            return null;
        }
        return DifferenceSets(b);
    }

    private Set DifferenceSets(Set b) {
        // 1. Создаем новое множество на основе текущего
        Set newSet = new Set(this);

        Item prevNewListIndex = newSet.tail;
        Item newListIndex = newSet.tail.next;
        Item bListIndex = b.tail.next;

        // 2. Ищем первый элемент
        while (newListIndex != newSet.tail && bListIndex != b.tail) {
            if (newListIndex.value < bListIndex.value) {
                prevNewListIndex = newListIndex;
                newListIndex = newListIndex.next;
            } else if (newListIndex.value > bListIndex.value) {
                bListIndex = bListIndex.next;
            } else {
                prevNewListIndex.next = prevNewListIndex.next.next;
                newListIndex = prevNewListIndex.next;
                bListIndex = bListIndex.next;
            }
        }

        // 3. Если достигли конца нового множества
        if (newListIndex == newSet.tail) {
            if (newListIndex.value != bListIndex.value) {
                Item prevItem = findPrev(bListIndex, b.tail, newListIndex.value);
                if (prevItem == null || prevItem.next.value != newListIndex.value) {
                    return newSet;
                }
            }
            if (newSet.tail == newSet.tail.next) {
                newSet.tail = null;
                return newSet;
            }
            Item temp = newSet.tail.next;
            prevNewListIndex.next = temp;
            newSet.tail = prevNewListIndex;
            return newSet;
        }

        // 4. Если последний элемент равен, удаляем его
        if (newListIndex.value == bListIndex.value) {
            prevNewListIndex.next = prevNewListIndex.next.next;
            return newSet;
        }

        // 5. Пытаемся удалить последний элемент b из нового множества
        Item prevItem = findPrev(newListIndex, newSet.tail, bListIndex.value);
        if (prevItem == null || prevItem.next.value != bListIndex.value) {
            return newSet;
        }
        if (prevItem.next == newSet.tail) {
            if (newSet.tail == newSet.tail.next) {
                newSet.tail = null;
                return newSet;
            }
            Item temp = newSet.tail.next;
            prevItem.next = temp;
            newSet.tail = prevItem;
            return newSet;
        }

        // 6. Завершаем удаление
        prevItem.next = prevItem.next.next;
        return newSet;
    }


    // Находится ли значение в интервале множества
    private boolean in_diapason(int value) {
        // 1. Если множество пустое
        if (tail == null) {
            return false;
        }
        // 2. Проверяем, находится ли значение в интервале
        return (value >= tail.next.value) && (value <= tail.value);
    }

    // Возвращает предыдущий элемент за первым меньшим или равным некоторому значению. Если нет такого - null
    private Item findPrev(int value) {
        Item prevItem = tail;
        Item currentItem = tail.next;

        // 1. Ищем элемент, который больше или равен значению
        while (currentItem != tail) {
            if (currentItem.value >= value) {
                return prevItem;
            }
            prevItem = currentItem;
            currentItem = currentItem.next;
        }

        // 2. Проверяем последний элемент
        return currentItem.value >= value ? prevItem : null;
    }

    // Возвращает предыдущий элемент за первым меньшим или равным некоторому значению, начиная с startItem до endItem. Если нет такого - null
    private Item findPrev(Item startItem, Item endItem, int value) {
        Item prevItem = startItem;
        Item currentItem = startItem.next;

        // 1. Ищем элемент, который больше или равен значению
        while (currentItem != endItem) {
            if (currentItem.value >= value) {
                return prevItem;
            }
            prevItem = currentItem;
            currentItem = currentItem.next;
        }

        // 2. Проверяем последний элемент
        return currentItem.value >= value ? prevItem : null;
    }

    // Копирует одно множество в другое
    private void copy(Set from, Set to) {
        // 1. Копируем конец
        to.tail = new Item(from.tail);
        to.tail.next = to.tail;

        Item prev = to.tail;
        Item fromItem = from.tail.next;

        // 2. Добавляем элементы в конец нового множества
        while (fromItem != from.tail) {
            Item temp = new Item(fromItem.value, to.tail);
            prev.next = temp;
            prev = temp;
            fromItem = fromItem.next;
        }
    }
}
