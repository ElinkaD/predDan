import java.util.Scanner;
import CloseHash.Dictionary;

public class Main {
    public static void main(String[] args) {
        // Считываем, пока не попадется символ E
        // Если символ равен F, то добавляем законодателя в список goodguys и удаляем из badguys
        // Если символ равен U, то добавляем законодателя в список badguys и удаляем из goodguys
        // Если символ равен ?, то проверяем, является ли законодатель членом множества goodguys,
        // если нет, аналогично проверяем в badguys, если тоже нет, значит законодатель еще не голосовал
        Scanner in = new Scanner(System.in);
        Dictionary goodGuys = new Dictionary();
        Dictionary badGuys = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        char c = ' ';


        while (c != 'E') {
            c = scanner.next().charAt(0);
            if (c == 'F') {
                String name = scanner.next();
                badGuys.DELETE(name.toCharArray());
                goodGuys.INSERT(name.toCharArray());
            } else if (c == 'U') {
                String name = scanner.next();
                goodGuys.DELETE(name.toCharArray());
                badGuys.INSERT(name.toCharArray());
            } else if (c == '?') {
                String name = scanner.next();
                if (!goodGuys.MEMBER(name.toCharArray()) && !badGuys.MEMBER(name.toCharArray())) {
                    System.out.println("Законодатель еще не голосовал");
                } else if (goodGuys.MEMBER(name.toCharArray())) {
                    System.out.println("Законодатель является членом goodguys");
                } else {
                    System.out.println("Законодатель является членом badguys");
                }
            }
        }
        System.out.println("Законодатели являются членами goodguys:");
        goodGuys.print();
        System.out.println("Законодатели являются членами badguys:");
        badGuys.print();
    }
}