package lesson21;

import ApiLesson.Person;
import ApiLesson.PersonApi;

import java.util.List;
import java.util.stream.Stream;

public class Main {
   public static void main(String[] args) {

      List<Person> personList = PersonApi.getPersonFromApi(5);

      for (Person person : personList) {
	 System.out.println(person);
      }

      System.out.println("___________________________________________________________________________________________");

      Stream.of(1,2,3,4,5,6,7,8,9,10,11,12)
	      .skip(3)
	      .limit(7)
	      .mapToInt(m->m)
	      .average()
	      .ifPresent(System.out::println);

      System.out.println("___________________________________________________________________________________________");

      Stream.of(1,2,3,4,5,6,7,8,9,10,11,12)
	      .findFirst()
	      .ifPresent(System.out::println);

      System.out.println("___________________________________________________________________________________________");

      Stream.of(1,2,3,4,5,6,7,8,9,10,11,12)
	      .findAny()
	      .ifPresent(System.out::println);
   }
}
