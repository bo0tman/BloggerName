import java.util.concurrent.ThreadLocalRandom;

public class User extends UserName implements Blogger {
    private String name;
    private String firstName;
    private String surName;

    User(String username) {
        super(username);
        this.name = username;
        splitName();
    }

    private void splitName() {
        String[] arr_name_string = name.trim().split("\\s+");
        setFirtname(arr_name_string[0]);
        String surname = "";
        for (int i = 1; i < arr_name_string.length; i++) {
            surname += " " + arr_name_string[i];
        }
        setSurname(surname.trim());
    }

    @Override
    public String randomNameGenerator() {
        StringBuilder builder = new StringBuilder();
        String blogger_name = lexicon + getName().trim();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + rand.nextInt(7);
            for (int i = 0; i < length; i++) {
                builder.append(blogger_name.charAt(rand.nextInt(blogger_name.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    @Override
    public String bloggerNameGenerator() {
        String[] random_names = { "Travelicious", "GoAround Guys", "SpringAround", "GymRats", "Applord", "Techwell",
                "Superware", "Your First Meal", "About a Blog", "Basic Blogs" };

        int randIdx = ThreadLocalRandom.current().nextInt(random_names.length);
        String randomElem = random_names[randIdx];
        return randomElem;
    }

    @Override
    public String bloggerName() {

        return bloggerNameGenerator() + " " + randomNameGenerator() + " " + getFirstName().charAt(0)
                + getSurName().charAt(0) + " for you";
    }

    private void setFirtname(String newName) {
        this.firstName = newName;
    }

    private void setSurname(String newName) {
        this.surName = newName;
    }

    private String getFirstName() {
        return firstName;
    }

    private String getSurName() {
        return surName;
    }

    private String getName() {
        return name;
    }

}
