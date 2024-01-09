import Map.ATD_LinkedList.*;
import Container.Container;

public class Main {
    public static void main(String[] args) {
        Map m = new Map();
        String s = "11", s1 = "22";
        m.Assign(s.toCharArray(), s1.toCharArray());
        s = "12";
        s1 = "21";
        m.Assign(s.toCharArray(), s1.toCharArray());
        s = "11";
        s1 = "33";
        System.out.println(m.Compute(s.toCharArray(), s1.toCharArray()));
        System.out.println(m);
    }
}
