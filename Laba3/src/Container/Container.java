package Container;

//класс для хранения элементов списка
public class Container {
    private char[] name = new char[30];
    private char[] address = new char[50];

    //геттер, для получения значений поля name
    public char[] getName() {
        return name;
    }
    //геттер, для изменения значений адреса
    public char[] getAddress() {
        return address;
    }
    public void setAddress(char[] newAddress){
        for (int i=0; i<newAddress.length; i++){
            address[i] = newAddress[i];
        }
    }

    public Container(char[] name, char[] address) {
        if(name.length > 30 || address.length > 50)
            throw new IllegalArgumentException();
        for(int i = 0; i < name.length; i++){
            this.name[i] = name[i];
        }
        for(int i = 0; i < address.length; i++){
            this.address[i] = address[i];
        }
    }
    public Container(Container container){
        name = new char[30];
        address = new char[50];
        int i = 0;
        for (; i < 30; i++){
            name[i] = container.name[i];
            address[i] = container.address[i];
        }
        for(; i < 50; i++){
            address[i] = container.address[i];
        }
    }

    public String AddressToString() {
        String str = "";
        for(int i = 0; i < address.length; i++){
            if(address[i] != 0){
                str += address[i];
            }
        }
        return str;
    }
    public String NameToString() {
        String str = "";
        for(int i = 0; i < name.length; i++){
            if(name[i] != 0){
                str += name[i];
            }
        }
        return str;
    }
    public Container(String name, String address) {
        this(name.toCharArray(),address.toCharArray());
    }

    // Переопределение метода equals(Object o): Проверяет, равны ли два объекта
    @Override
    public boolean equals(Object object) { // посимвольное сравнение
        //1. Проверяем, ссылаются ли оба объекта на одну и ту же область памяти.
        //Если это так, то объекты считаются равными и метод возвращает true.
        //2. Проверяем, является ли объект o равным null. Если это так, то объекты не могут быть равными, и метод возвращает false.
        //3. Приведение объект o к типу Container и получает его массивы символов имени и адреса, используя геттеры getName() и getAddress() соответственн
        //4. Сравниваем по-символьно массивы в массиве name с соответствующим символом в массиве newname, аналогично для address с массивом newaddress.
        //          Если хотя бы одна пара символов не совпадает, метод возвращает false.
        // 5. Если все символы совпадают, метод возвращает true, что означает, что объекты this и o считаются равными.
        if (this == object) return true;
        if (object == null) return false;
        Container container = (Container) object;
        char[] newname = container.getName();
        char[] newaddress = container.getAddress();

        int i;
        for (i = 0; i < name.length; i++)
            if (name[i] != newname[i])
                return false;
        for (i = 0; i < address.length; i++)
            if (address[i] != newaddress[i])
                return false;

        return true;
    }
}

