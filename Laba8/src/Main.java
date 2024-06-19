public class Main {
    public static void main(String[] args) {
        ManyToMany m = new ManyToMany();

        char[] Elina = {'E' , 'l' , 'i', 'n', 'a', '\0'};

        char[] Liza = {'L' , 'i' , 'z', 'a', '\0'};

        char[] Kate = {'K' , 'a' , 't', 'e', '\0'};


        m.putStudentOnCourse(Elina,2);
        m.putStudentOnCourse(Elina,1);
        m.putStudentOnCourse(Liza,1);
        m.putStudentOnCourse(Liza,3);
        m.putStudentOnCourse(Kate,1);
        m.putStudentOnCourse(Kate,1);

        System.out.print("Список курсов Элины: ");
        m.listCourses(Elina);
        System.out.println();

        System.out.print("Список курсов Лизы: ");
        m.listCourses(Liza);
        System.out.println();

        System.out.print("Список курсов Кати: ");
        m.listCourses(Kate);
        System.out.println();

        System.out.print("Список всех студентов на 1 курсе: ");
        m.listStudents(1);
        System.out.print("Список всех студентов на 2 курсе: ");
        m.listStudents(2);
        System.out.print("Список всех студентов на 3 курсе: ");
        m.listStudents(3);

        System.out.println("Удаляем Элину со всех курсов");
        m.removeStudentInAllCourses(Elina);
        System.out.print("Список курсов Элины: ");
        m.listCourses(Elina);
        System.out.println();
        System.out.print("Список всех студентов на 1 курсе: ");
        m.listStudents(1);
        System.out.println();



        System.out.println("Удаляем 1 курс у всех");
        m.removeCourceEverywhere(1);
        System.out.print("Список всех студентов на 1 курсе: ");
        m.listStudents(1);
    }
}