package lesson20Streams;

import ApiLesson.Person;
import ApiLesson.PersonApi;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
   public static void main(String[] args) {

      List<Person> personList = PersonApi.getPersonFromApi(10);

      for (Person person: personList) {
	 System.out.println(person);
      }
      System.out.println("__________________________________________________________________________________________");

      List<Person> spainList = personList.stream()
	      .filter(person -> person.getCountry().equals("Spain"))
	      .collect(Collectors.toList());

      personList.stream()
	      .map(person -> person.getUsername())
	      .forEach(System.out::println);
   }
}
