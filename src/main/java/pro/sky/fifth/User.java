package pro.sky.fifth;

import java.util.Objects;

public class User {
    private final int age;
    private final String name;

    public User (int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public String getName () {
        return name;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name);
    }

    @Override
    public int hashCode () {
        return Objects.hash(age, name);
    }

    @Override
    public String toString () {
        return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
