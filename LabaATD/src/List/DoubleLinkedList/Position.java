package List.DoubleLinkedList;
import List.DoubleLinkedList.List.Node;

public class Position{
    //переменная для хранения узла
    private Node node;
    //копирующий конструктор
    public Position(Node node) {
        this.node = node;
    }

    //геттер
    public Node getNode() {return node;}
    //сеттер
    public void setNode(Node node) {
        this.node = node;
    }

    //метод сравнивает два объекта типа Position по значению поля pos
    @Override
    public boolean equals(Object object) {
        //1.Переопределяем метод equals(), который принимает в качестве параметра объект object и сравнивает его с текущим объектом this.
            //1.Если объекты ссылаются на один и тот же адрес памяти, то метод возвращает true, так как это означает, что они являются одним и тем же объектом.
            //2.Если объект o равен null, то метод возвращает node == null.
        //2. Создаем новый объект newnode типа Position из объекта object.
        //3.Сравнивает значения node текущего объекта и объекта newnode. Если они равны, то метод возвращает true, в противном случае - false.
        if (this == object) return true;
        if (object == null)
            return node == null;
        Position p = (Position) object;
        return node == p.node;
    }
}

