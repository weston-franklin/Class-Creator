import java.util.*;

public class interactable {
    public static final Scanner sc = new Scanner(System.in);

    static{
        System.out.println("beginning program");
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter class name without spaces and hit enter when you are done: ");
        String className = sc.nextLine();
        classCreator newClass = new classCreator();
        newClass.createClass(className);
        System.exit(0);
    }
}
