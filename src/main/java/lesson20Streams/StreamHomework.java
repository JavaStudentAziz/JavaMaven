package lesson20Streams;

import ApiLesson.Person;

import java.time.LocalDateTime;
import java.util.List;

public class StreamHomework {

    public static void femaleList(List<Person> personList, int age) {

        personList.stream()
                .filter(person -> person.getAge() > age)
                .filter(person -> person.getGender().equals("female"))
                .forEach(System.out::println);

    }

    public static void maleList(List<Person> personList, int age) {

        personList.stream()
                .filter(person -> person.getAge() < age)
                .filter(person -> person.getGender().equals("male"))
                .forEach(person -> System.out.println(person.getName() + " " + person.getLastName() + " " + person.getDateOfBirthday()));

    }

    public static List<Person> oldManList(List<Person> personList, int age) {

        return personList.stream()
                .filter(person -> person.getAge() > age)
                .toList();

    }

    public static void lastnameList(List<Person> personList, int length) {

        personList.stream()
                .filter(person -> person.getLastName().length() < length)
                .forEach(System.out::println);
    }
}
