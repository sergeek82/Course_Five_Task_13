package pro.sky.fifth;

import java.io.FilterOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {
        List<User> userList = Arrays.asList(new User(12, "Mike"),
                new User(32, "John"),
                new User(32, "John"),
                new User(82, "Jenny"),
                new User(32, "Gabriel"),
                new User(32, "Batty"),
                new User(32, "Andrew"),
                new User(44, "Taylor"),
                new User(44, "Roman"),
                new User(17, "Chloe"));
        System.out.println("Initial user list is: ");
        userList.forEach(System.out::println);
        Main main = new Main();
        Set<User> uniqueUsers = main.getUniqueUsers(userList);
        System.out.println("\nResult of the getUniqueUsers method is: ");
        uniqueUsers.forEach(System.out::println);
        List<User> sortedList = main.getSortedList(uniqueUsers);
        System.out.println("\nResult of the getSortedLis method is:");
        sortedList.forEach(System.out::println);
        User oldUser = main.getOldestUser(sortedList);
        System.out.println("\nResult of the getOldestUser is: " + oldUser);
    }

    private Set<User> getUniqueUsers (Collection<User> users) {
        return new HashSet<>(users);
    }

    private List<User> getSortedList (Collection<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge).thenComparing(User::getName))
                .collect(Collectors.toList());
    }

    private User getOldestUser (Collection<User> users) {
        return users.stream().max(Comparator.comparing(User::getAge)).orElseThrow(NoSuchElementException::new);
    }
}