package lesson20Streams;

import ApiLesson.Person;
import ApiLesson.PersonApi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        List<Person> personList = PersonApi.getPersonFromApi(10);

        for (Person person : personList) {
            System.out.println(person);
        }
        System.out.println("__________________________________________________________________________________________");

        List<Person> spainList = personList.stream()
                .filter(person -> person.getCountry().equals("Spain"))
                .toList();

        personList.stream()
                .map(Person::getUsername)
                .forEach(System.out::println);

        System.out.println("__________________________________________________________________________________________");

        StreamHomework.femaleList(personList, 20);
        System.out.println("__________________________________________________________________________________________");
        StreamHomework.maleList(personList, 38);
        System.out.println("__________________________________________________________________________________________");
        List<Person> olds = StreamHomework.oldManList(personList, 50);
        for (Person person: olds) {
            System.out.println(person);
        }
        System.out.println("__________________________________________________________________________________________");
        StreamHomework.lastnameList(personList, 5);
    }
}
