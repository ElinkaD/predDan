package List;
import List.LinkedList.*;
import List.Container.Container;

public class Main {
    public static void main(String[] args) {
        Position p, q;

        List list = new List();

        init(list); //инициализируем список
        list.PrintList();

        //проход по списку с помощью цикла while для удаления повтор элементов
        p = list.First();
        while (!p.equals(list.End())) {
            q = list.Next(p);
            while (!q.equals(list.End())) {
                if (list.Retrieve(p).equals(list.Retrieve(q))) {
                    list.Delete(q);
                } else {
                    q = list.Next(q);
                }
            }
            p = list.Next(p);
        }
        list.Delete(list.First());
        //вывод результата
        list.PrintList();
    }

    private static void init(List list) {
        //создание контейнеров и вставка в массив
        Container container1 = new Container("Elina", "Saint-Peterburg");
        Container container2 = new Container("Liza", "Tomsk");
        Container container3 = new Container("Kate", "Usinsk");
        Container container4 = new Container("Roma", "Busuluk");
        Container container5 = new Container("Liza", "Tomsk");
        Container container6 = new Container("Polina", "Orlov");

        list.Insert(list.End(), container1);
        list.Insert(list.End(), container3);
        list.Insert(list.End(), container2);
        list.Insert(list.End(), container4);
        list.Insert(list.End(), container5);
        list.Insert(list.End(), container6);
    }
}
