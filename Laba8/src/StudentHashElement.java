public class StudentHashElement extends Pointer {
    public RegistrationRecord nextRecord; // Следующая регистрационная запись
    public char[] studentName;

    public StudentHashElement(char[] s, RegistrationRecord n) {
        studentName = new char[s.length];
        for (int i = 0; i < studentName.length; i++){
            studentName[i] = s[i];
        }
        nextRecord = n;
    }

    // проверка на удалённый элемент
    public boolean isDeleted(){
        return studentName[0] == '\0';
    }

    public void printName(){ // Вывод имени на печать посимвольно, пока не 0
        if (studentName == null)
            return;
        if (studentName[0] == '\0')
            return;

        for (int i = 0; i < studentName.length; i++){
            if (studentName[i] != '\0'){
                System.out.print(studentName[i]);
            }
            else {
                System.out.println();
                return;
            }
        }
    }

    public boolean equals(char[] n){
        int i;
        for (i = 0; studentName[i] != '\0' &&  n[i] != '\0'; i++){
            if (studentName[i] != n[i])
                return false;

        }
        if (studentName[i] != n[i])
            return false;
        return true;
    }
}