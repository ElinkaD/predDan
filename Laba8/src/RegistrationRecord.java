public class RegistrationRecord extends Pointer {
    private Pointer course_next;
    private Pointer student_next;

    public RegistrationRecord(Pointer course, Pointer student) {
        course_next = course;
        student_next = student;
    }

    public Pointer getCourse_next() {
        return course_next;
    }

    public Pointer getStudent_next() {
        return student_next;
    }

    public void setCourse_next(Pointer l1) {
        course_next = l1;
    }

    public void setStudent_next(Pointer l2) {
        student_next = l2;
    }

    @Override
    public boolean hasNext()
    {
        return true;
    } // переопределяем метод родительского класса
}
