package List.Cursor;

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
        //2. Создаем новый объект position типа Position из объекта object.
        //3.Сравнивает значения node текущего объекта и объекта position. Если они равны, то метод возвращает true, в противном случае - false.
        Position position = (Position) object;
        return pos == position.pos;
    }
}