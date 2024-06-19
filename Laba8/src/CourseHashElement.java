public class CourseHashElement extends Pointer{
    public int course;
    public RegistrationRecord nextRecord; // Следующая регистрационная запись

    public CourseHashElement(int c, RegistrationRecord n){
        course = c;
        nextRecord = n;
    }
}

