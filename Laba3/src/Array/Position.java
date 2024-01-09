package Array;

public class Position {
    //переменная для хранения узла
    private int pos;
    //копирующий конструктор
    public Position(int pos) {
        this.pos = pos;
    }
    //геттер
    public int getPos() {
        return pos;
    }
    //сеттер
    public void setPos(int pos) {
        this.pos = pos;
    }

    //метод сравнивает два объекта типа Position по значению поля pos
    @Override
    public boolean equals(Object object) {
        //1.Переопределяем метод equals(), который принимает в качестве параметра объект object и сравнивает его с текущим объектом this.
            //1.Если объекты ссылаются на один и тот же адрес памяти, то метод возвращает true, так как это означает, что они являются одним и тем же объектом.
            //2.Если объект o равен null, то метод возвращает node == null.
        //2. Создаем новый объект position типа Position из объекта object.
        //3.Сравнивает значения node текущего объекта и объекта position. Если они равны, то метод возвращает true, в противном случае - false.
        if (this == object) return true;
        if (object == null) return false;

        Position position = (Position) object;
        return pos == position.pos;
    }
}

