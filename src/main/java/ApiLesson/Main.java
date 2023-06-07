package ApiLesson;

import java.util.List;

public class Main {

   public static void main(String[] args) {

      Person person = PersonApi.getPersonFromApi();
      System.out.println(person);

      List<Person> personList = PersonApi.getPersonList(5);

      for (Person pers: personList) {
         System.out.println(pers);
      }

   }
}
