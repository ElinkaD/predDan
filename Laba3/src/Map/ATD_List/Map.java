package Map.ATD_List;

import Array.*;
import Container.Container;
import Map.ATD_Map;

public class Map implements ATD_Map{
    private List map = new List();
    //делает отображение пустым
    @Override
    public void Makenull() {
        map.MakeNull();
    }
    //делает M(d) равным r независимо от того, как M(d) было определено ранее.
    @Override
    public void Assign(char[] d, char[] r) {
        //Создаем копию объекта container с массивами d и r и берем первую позицию в pos
        Container container = new Container(d,r);
        Position pos = map.First();

        //цикл по списку пока не дойдем до конца или не выполним замену
        while (!pos.equals(map.End())){
            //Находим отображение c помощью метода сравнения двух массивов, для текущего списка, чтобы достать символьный массив по позиции используем Retrieve
            // заменяем его на M(r) и удаляем, выходя из цикла
            if (equalsArr(d, map.Retrieve(pos).getName())){
                map.Insert(pos, container);
                map.Delete(map.Next(pos));
                return;
            }
            //переходим на следующий элемент
            pos = map.Next(pos);
        }
        //в случае если d не определено, создаем новый элемент
        map.Insert(pos, container);
    }
    //возвращает значение true и присваивает переменной r значение M(d), если последнее определено, и возвращает false в противном случае.
    @Override
    public boolean Compute(char[] d, char[] r){
        //находим первую позицию методом First и записываем ее в pos
        Position pos = map.First();
        //цикл по списку пока не дойдем до конца или не сработает if
        while (!pos.equals(map.End())){
            //Находим отображение c помощью метода сравнения двух массивов, для текущего списка, чтобы достать символьный массив по позиции используем Retrieve
            //  присваиваем переменной r значение M(d)
            Container temp = map.Retrieve(pos);
            if (equalsArr(temp.getName(), d)){
                temp.setAddress(r);
                return true;
            }
            //переходим на следующий элемент
            pos = map.Next(pos);
        }
        //в случае если d не определено, создаем новый элемент
        return false;
    }

    //сравнение элементов массивов
    private boolean equalsArr(char[] A, char[] B) {
        if (A.length != B.length) return false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }
}
