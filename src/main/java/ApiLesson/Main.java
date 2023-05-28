package ApiLesson;

public class Main {

   public static void main(String[] args) {

      Person person = PersonApi.getPersonFromApi();
      System.out.println(person);

   }
}
