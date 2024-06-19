package Array;

public class Set {

    // Класс, представляющий позицию в массиве
    public static class position {
        int index; // индекс в массиве
        int pos; // позиция внутри элемента массива

        public position(int i, int p) {
            index = i; // инициализация индекса
            pos = p; // инициализация позиции
        }
    }

    private static final int leftBit = 0b10000000000000000000000000000000; // старший бит
    private int[] array; // массив для хранения элементов множества
    private int zeroPosition; // позиция нуля в массиве
    private int start, end; // границы множества

    // Установить бит в 1
    public int SetBit(int reg, int bit) {
        reg |= (1 << bit); // установить 1 в указанном бите
        return reg;
    }

    // Установить бит в 0
    public int ClearBit(int reg, int bit) {
        reg &= (~(1 << bit)); // установить 0 в указанном бите
        return reg;
    }

    // Инвертировать бит
    public int InvBit(int reg, int bit) {
        reg ^= (1 << bit); // инвертировать указанный бит
        return reg;
    }

    // Проверить, установлен ли бит в 1
    public boolean BitIsSet(int reg, int bit) {
        return ((reg & (1 << bit)) != 0); // проверить, установлен ли бит в 1
    }

    // Проверить, установлен ли бит в 0
    public boolean BitIsClear(int reg, int bit) {
        return ((reg & (1 << bit)) == 0); // проверить, установлен ли бит в 0
    }

    // Конструктор от границ
    public Set(int from, int to) {
        // Проверяем корректность ввода
        if ((from == 0 && to == 0) || (from > to))
            return;

        start = from;
        end = to;

        // Если граница начинается с отрицательного числа
        if (start < 0) {
            int negativeLen = start >= -31 ? -1 : start / 32 - 1;
            int positiveLen = end <= 31 ? 0 : end / 32;
            array = new int[Math.abs(negativeLen) + positiveLen + 1];
            zeroPosition = -negativeLen;
            return;
        }

        zeroPosition = 0;
        position p1 = findInArray(start);
        position p2 = findInArray(end);

        array = new int[p2.index - p1.index + 1];
        zeroPosition = -p1.index;
    }

    // Копирующий конструктор
    public Set(Set a) {
        this.start = a.start;
        this.end = a.end;
        this.zeroPosition = a.zeroPosition;
        this.array = new int[a.array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = a.array[i];
        }
    }

    // Метод для вывода множества на экран
    public void PRINT() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 32; j++)
                if (BitIsSet(array[i], j)) {
                    System.out.print((-zeroPosition + i) * 32 + j + " ");
                }
        }
        System.out.println();
    }

    // Вставка элемента в множество
    public void INSERT(int q) {
        if (q < start || q > end) return;
        position p = findInArray(q);
        array[p.index] = SetBit(array[p.index], p.pos);
    }

    // Удаление элемента из множества
    public void DELETE(int q) {
        if (q < start || q > end) return;
        position p = findInArray(q);
        array[p.index] = ClearBit(array[p.index], p.pos);
    }

    // Присвоить текущее множество другому множеству
    public void ASSIGN(Set a) {
        this.start = a.start;
        this.end = a.end;
        this.zeroPosition = a.zeroPosition;
        this.array = new int[a.array.length];
        System.arraycopy(a.array, 0, this.array, 0, a.array.length);
    }


    // Поиск минимального элемента в множестве
    public int MIN() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                for (int j = 0; j < 32; j++) {
                    if (BitIsSet(array[i], j)) {
                        return ((-zeroPosition + i) * 32 + j);
                    }
                }
            }
        }
        throw new RuntimeException("The set is empty");
    }

    // Поиск максимального элемента в множестве
    public int MAX() {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                for (int j = 31; j >= 0; j--) {
                    if (BitIsSet(array[i], j)) {
                        return ((-zeroPosition + i) * 32 + j);
                    }
                }
            }
        }
        throw new RuntimeException("The set is empty");
    }

    // Проверка равенства множеств
    public boolean EQUAL(Set a) {
        if (a == null) throw new RuntimeException("");
        if (a == this) return true;
        if (end < a.start || a.end < start) return false;

        // Проверка левой части на наличие нулей
        Set leftSet = start < a.start ? this : a;
        Set secondSet = start < a.start ? a : this;
        int intersectionStart = leftSet.findInArray(secondSet.start).index;
        for (int i = 0; i < intersectionStart; i++) {
            if (leftSet.array[i] != 0) return false;
        }

        // Проходим пересечение
        int secondSetIntersectionStart = 0;
        int intersectionEnd = secondSet.findInArray(Math.min(end, a.end)).index;
        for (int i = intersectionStart; i <= intersectionEnd; i++) {
            if (leftSet.array[i] != secondSet.array[secondSetIntersectionStart]) return false;
            secondSetIntersectionStart++;
        }

        // Проверка правой части массива
        secondSet = end < a.end ? a : this;
        leftSet = end < a.end ? this : a;
        intersectionEnd = secondSet.findInArray(leftSet.end).index;
        for (int i = intersectionEnd + 1; i < secondSet.findInArray(end).index; i++) {
            if (secondSet.array[i] != 0) return false;
        }

        return true;
    }

    // Очистка множества
    public void MAKENULL() {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    // Проверка, является ли элемент членом множества
    public boolean MEMBER(int q) {
        if (isEmpty()) return false;
        if (q < start || q > end) return false;
        position p = findInArray(q);
        return BitIsSet(array[p.index], p.pos);
    }

    // Поиск множества, содержащего элемент
    public Set FIND(Set a, int x) {
        if (!(isEmpty() || (x < start || x > end))) {
            position p = findInArray(x);
            if (BitIsSet(array[p.index], p.pos)) {
                return this;
            }
        }

        if (!(a.isEmpty() || (x < a.start || x > a.end))) {
            position p = a.findInArray(x);
            if (a.BitIsSet(array[p.index], p.pos)) {
                return a;
            }
        }

        return null;
    }

    // Объединение множеств
    public Set MERGE(Set a) {
        if (a == this) return new Set(a);
        return mergeSets(a);
    }

    // Объединение множеств
    public Set UNION(Set a) {
        if (a == this) return new Set(a);
        return mergeSets(a);
    }

    // Пересечение множеств
    public Set INTERSECTION(Set a) {
        if (a == this) return new Set(a);
        if (a.end < start || a.start > end) return null;

        int intersectionStart = Math.max(a.start, start);
        int intersectionEnd = Math.min(a.end, end);

        Set c = new Set(intersectionStart, intersectionEnd);

        int firstNew = c.findInArray(c.start).index;
        int lastNew = c.findInArray(c.end).index;

        int firstSetStart = findInArray(intersectionStart).index;
        int secondSetStart = a.findInArray(intersectionStart).index;

        for (int i = firstNew; i <= lastNew; i++) {
            c.array[i] = array[firstSetStart] & a.array[secondSetStart];
            firstSetStart++;
            secondSetStart++;
        }
        return c;
    }

    // Разность множеств
    public Set DIFFERENCE(Set a) {
        if (a == this) return new Set(start, end);

        Set newSet = new Set(this);

        // Если нет пересечения
        if (end < a.start || a.end < start) {
            return newSet;
        }

        int secondSetStart;
        if (start <= a.start)
            secondSetStart = a.findInArray(a.start).index;
        else
            secondSetStart = a.findInArray(start).index;

        int intersectionEnd;
        if (end <= a.end)
            intersectionEnd = findInArray(end).index;
        else
            intersectionEnd = findInArray(a.end).index;

        for (int i = 0; i <= intersectionEnd && secondSetStart < a.array.length; i++) {
            newSet.array[i] = array[i] & ~(a.array[secondSetStart]);
            secondSetStart++;
        }

        return newSet;
    }

    // Найти позицию в массиве для заданного значения
    public position findInArray(int q) {
        // Если старт в 0
        if (start == 0)
            return new position(q / 32, q % 32);

        // Если старт меньше нуля
        if (start < 0) {
            if (q < 0)
                return new position(zeroPosition - Math.abs(q / 32) - 1, q % 32);
            else
                return new position(zeroPosition + q / 32, q % 32);
        }

        // Если старт больше нуля
        return new position(q / 32 + zeroPosition, q % 32);
    }

    // Проверка, пустое ли множество
    private boolean isEmpty() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) return false;
        }
        return true;
    }

    // Метод объединения множеств
    private Set mergeSets(Set a) {
        Set n = new Set(Math.min(a.start, start), Math.max(a.end, end));

        int counter = 0;
        int nStart = n.findInArray(start).index;
        int nEnd = n.findInArray(end).index;
        for (int i = nStart; i < nEnd; i++) {
            n.array[i] |= array[counter];
            counter++;
        }

        counter = 0;
        int aStart = n.findInArray(a.start).index;
        int aEnd = n.findInArray(a.end).index;
        for (int i = aStart; i <= aEnd; i++) {
            n.array[i] |= a.array[counter];
            counter++;
        }
        return n;
    }

    // Проверка, пересекаются ли множества
    public boolean IS_INTERSECT(Set b) {
        Set intersection = INTERSECTION(b);
        return !intersection.isEmpty();
    }
}
