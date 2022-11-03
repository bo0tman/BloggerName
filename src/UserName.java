import java.util.regex.*;
import java.util.*;

public class UserName
        extends Validation {
    private String name;
    final private String USERNAME_REGEX = "^[[a-zA-Z]+\\s]+$";
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final Random rand = new Random();
    final Set<String> identifiers = new HashSet<String>();

    UserName(String username) {
        this.name = username;
    }

    @Override
    boolean UserNameValidator() {
        Pattern p = Pattern.compile(USERNAME_REGEX);// . represents single character
        Matcher m = p.matcher(this.name);
        return m.matches();
    }
}
