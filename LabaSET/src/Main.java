import Array.Set;

public class Main {
    public static void main(String[] args) {
        Set A = new Set(-100, 32);
        A.INSERT(-30);
        A.INSERT(-31);
        A.INSERT(10);
        System.out.println("Множество А");
        A.PRINT();

        Set B = new Set(-100,100);
        B.INSERT(-42);
        B.INSERT(-30);
        B.INSERT(5);
        System.out.println("Множество Б");
        B.PRINT();

        System.out.println("Пересечение множеств А и Б");
        A.INTERSECTION(B).PRINT();

        System.out.println("Объединение множеств А и Б");
        A.UNION(B).PRINT();

        System.out.println("Разницу множеств А и Б");
        A.DIFFERENCE(B).PRINT();

        System.out.println("Минимальное число из А");
        System.out.println(A.MIN());

        System.out.println("Максимальное число из А");
        System.out.println(A.MAX());

        B.DELETE(-30);
        System.out.println("A Merge B: ");
        if(!A.IS_INTERSECT(B)) {
            A.MERGE(B).PRINT();
        }
        else {
            System.out.println("Множества пересекаются");
        }

        System.out.println("Ищет 10 в множестве А");
        A.FIND(B, 10).PRINT();
    }
}
