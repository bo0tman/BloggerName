import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter Username: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String username = scanner.nextLine();

            User user = new User(username);
            if (user.UserNameValidator()) {
                String name = user.bloggerName();
                System.out.println(name);
            } else {
                System.out.println("Please Enter Valid Name");
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
