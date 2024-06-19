public class ManyToMany {
    // Хранение хеш-таблиц студентов и курсов
    private StudentHash s_Hash;
    private CourseHash c_Hash;

    ManyToMany(){
        s_Hash = new StudentHash();
        char[] Name = {'E' , 'l' , 'i', 'n', 'a', '\0'};
        s_Hash.INSERT(Name);
        Name = new char[]{'L' , 'i' , 'z', 'a', '\0'};
        s_Hash.INSERT(Name);
        Name = new char[]{'K' , 'a' , 't', 'e', '\0'};
        s_Hash.INSERT(Name);

        c_Hash = new CourseHash();
        c_Hash.INSERT(1);
        c_Hash.INSERT(2);
        c_Hash.INSERT(3);

        s_Hash.print();
        c_Hash.print();
        System.out.println();
    }

    // Добавить студента на курс
    public void putStudentOnCourse(char[] name, int course){
        StudentHashElement c = s_Hash.MEMBER(name); // Найти студента по имени
        if(c == null) return;
        CourseHashElement n = c_Hash.MEMBER(course); // Найти курс по номеру
        if(n == null) return;

        if (onCourse(n, name)){
            return; // Если студент уже на курсе, ничего не делать
        }

        // Создание новой записи о регистрации
        RegistrationRecord temp = new RegistrationRecord(
                n.nextRecord == null ? n : n.nextRecord,
                c.nextRecord == null ? c : c.nextRecord);

        n.nextRecord = temp; // Обновление связей
        c.nextRecord = temp;
    }

    // Печать списка курсов, на которые записан студент
    public void listCourses(char[] name){
        StudentHashElement n = s_Hash.MEMBER(name); // Найти студента по имени
        if(n == null) return;

        Pointer temp = n.nextRecord;
        if (temp == null) return;

        while (temp.hasNext()){
            System.out.print(find_course((RegistrationRecord) temp).course + " "); // Печать курса
            temp = ((RegistrationRecord) temp).getStudent_next();
        }

        System.out.println();
    }

    // Печать списка студентов, записанных на курс
    public void listStudents(int course){
        CourseHashElement n = c_Hash.MEMBER(course); // Найти курс по номеру
        if(n == null) return;

        Pointer temp = n.nextRecord;
        if (temp == null) return;

        while (temp.hasNext()){
            find_student((RegistrationRecord) temp).printName(); // Печать имени студента
            temp = ((RegistrationRecord) temp).getCourse_next();
        }

        System.out.println();
    }

    // Удалить студента с курса
    public void removeStudentFromCourse(int course, char[] name){
        StudentHashElement c = s_Hash.MEMBER(name); // Найти студента по имени
        if(c == null) return;
        CourseHashElement n = c_Hash.MEMBER(course); // Найти курс по номеру
        if(n == null) return;

        // Найти предыдущую запись со стороны курса
        Pointer result = findPrevStudent(n, name);
        if (result == null) return;

        if (result.hasNext()){
            RegistrationRecord r1 = (RegistrationRecord) result;
            // Обновление связей, если запись последняя
            if (!r1.getCourse_next().hasNext()) r1.setCourse_next(n);
            else r1.setCourse_next(((RegistrationRecord) r1.getCourse_next()).getCourse_next());
        }
        else {
            if (n.nextRecord.hasNext()){
                RegistrationRecord temp2 = n.nextRecord;
                if (temp2.getCourse_next().hasNext()) n.nextRecord = ((RegistrationRecord) temp2.getCourse_next());
                else n.nextRecord = null;
            }
        }

        // Найти предыдущую запись со стороны студента
        result = findPrevCourse(c, course);
        if (result == null) return;

        if (result.hasNext()){
            RegistrationRecord r2 = (RegistrationRecord) result;
            // Обновление связей, если запись последняя
            if (!r2.getStudent_next().hasNext()) r2.setStudent_next(c);
            else r2.setStudent_next(((RegistrationRecord) r2.getStudent_next()).getStudent_next());
        }
        else {
            RegistrationRecord temp2 = c.nextRecord;
            if (temp2.getStudent_next().hasNext()) c.nextRecord = ((RegistrationRecord) temp2.getStudent_next());
            else c.nextRecord = null;
        }
    }

    // Удалить студента со всех курсов
    public void removeStudentInAllCourses(char[] name){
        StudentHashElement c = s_Hash.MEMBER(name); // Найти студента по имени
        if(c == null)
            return;

        // Проверить, записан ли студент на курсы
        if (c.nextRecord == null)
            return;

        Pointer temp = c.nextRecord;

        while (temp.hasNext()){
            // Найти курс, на который записан студент
            CourseHashElement course = ((RegistrationRecord) temp).getCourse_next().hasNext() ?
                    find_course((RegistrationRecord) ((RegistrationRecord) temp).getCourse_next()) :
                    (CourseHashElement) ((RegistrationRecord) temp).getCourse_next();

            Pointer result = findPrevStudent(course, name);

            if (result == null)
                continue;

            // Обновление связей, если предыдущая запись - регистрация
            if (result.hasNext()) {
                RegistrationRecord temp2 = (RegistrationRecord) result;
                temp2.setCourse_next(((RegistrationRecord)temp2.getCourse_next()).getCourse_next());
            }
            else {
                // Обновление связей, если есть другие регистрации на курсе
                if (course.nextRecord.getCourse_next().hasNext())
                    course.nextRecord = ((RegistrationRecord) course.nextRecord.getCourse_next());
                else
                    course.nextRecord = null; // Удаление единственной регистрации
            }
            temp = ((RegistrationRecord) temp).getStudent_next();
        }
        c.nextRecord = null; // Обнуление ссылок студента
    }

    // Удалить курс у всех студентов
    public void removeCourceEverywhere(int cource){
        CourseHashElement c = c_Hash.MEMBER(cource); // Найти курс по номеру
        if(c == null)
            return;

        // Проверить, записаны ли студенты на курс
        if (c.nextRecord == null)
            return;

        Pointer temp = c.nextRecord;

        while (temp.hasNext()){
            // Найти студента, записанного на курс
            StudentHashElement s = ((RegistrationRecord) temp).getStudent_next().hasNext() ?
                    find_student((RegistrationRecord) ((RegistrationRecord) temp).getStudent_next()) :
                    (StudentHashElement) ((RegistrationRecord) temp).getStudent_next();

            Pointer result = findPrevCourse(s, cource);

            if (result == null)
                continue;

            // Обновление связей, если предыдущая запись - регистрация
            if (result.hasNext()) {
                RegistrationRecord temp2 = (RegistrationRecord) result;
                temp2.setStudent_next(((RegistrationRecord)temp2.getStudent_next()).getStudent_next());
            }
            else {
                // Обновление связей, если есть другие регистрации у студента
                if (s.nextRecord.getStudent_next().hasNext())
                    s.nextRecord = ((RegistrationRecord) s.nextRecord.getStudent_next());
                else
                    s.nextRecord = null; // Удаление единственной регистрации
            }
            temp = ((RegistrationRecord) temp).getCourse_next();
        }
        c.nextRecord = null; // Обнуление ссылок курса
    }

    // Найти курс по записи регистрации
    private CourseHashElement find_course(RegistrationRecord r){
        Pointer p = r.getCourse_next();

        while (p.hasNext())
            p = ((RegistrationRecord) p).getCourse_next();

        return ((CourseHashElement) p);
    }

    // Найти студента по записи регистрации
    private StudentHashElement find_student(RegistrationRecord r){
        Pointer p = r.getStudent_next();

        while (p.hasNext())
            p = ((RegistrationRecord) p).getStudent_next();

        return (((StudentHashElement) p));
    }

    // Найти предыдущую запись студента по курсу
    private Pointer findPrevStudent(CourseHashElement s, char[] name){
        Pointer p = s.nextRecord;
        Pointer p2 = s;

        while (p.hasNext()) {
            if (find_student((RegistrationRecord) p).equals(name))
                return p2;
            p2 = p;
            p = ((RegistrationRecord) p).getCourse_next();
        }
        return null;
    }

    // Проверить, записан ли студент на курс
    private boolean onCourse(CourseHashElement s, char[] name){
        Pointer p = s.nextRecord;
        if(p == null) return false;

        while (p.hasNext()) {
            if (find_student((RegistrationRecord) p).equals(name))
                return true;
            p = ((RegistrationRecord) p).getCourse_next();
        }
        return false;
    }

    // Найти предыдущую запись курса по студенту
    private Pointer findPrevCourse(StudentHashElement s, int course){
        Pointer p = s.nextRecord;
        Pointer p2 = s;

        while (p.hasNext()) {
            if (find_course((RegistrationRecord) p).course == course)
                return p2;
            p2 = p;
            p = ((RegistrationRecord) p).getStudent_next();
        }
        return null;
    }
}
