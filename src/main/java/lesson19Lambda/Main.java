package lesson19Lambda;

import ApiLesson.Person;
import ApiLesson.PersonApi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

public class Main {
   public static void main(String[] args) {

      List<Person> personList = PersonApi.getPersonList(10);

      for (Person person : personList) {
	 System.out.println(person);
      }

      System.out.println("___________________________________________________________________________________________");

      /*LambdaExample.sortLambda(personList, new Predicato<Person>() {
	 @Override
	 public boolean test(Person person) {
	    return LocalDateTime.now().getYear()
		    - person.getDateOfBirthday().getYear() < 30;
	 }
      });
      System.out.println("___________________________________________________________________________________________");

      // слева от стрелки то, что мы передаем
      // -> - магическая стрелка
      // справа результат

      LambdaExample.sortLambda(personList,
	      (Person person) -> {
		 System.out.println("func checking");
		 return person.getCountry().equals("Spain");
	      });

      System.out.println("___________________________________________________________________________________________");

      LambdaExample.sortLambda(personList,
	      p -> p.getCountry().equals("Spain"));
*/
      // слева 1 тип - можно без скобок
      // больше 1 типо - закрывать в скобки
      // ->
      // если ставим фигурные скобки - должен быть return
      // фигурные скобки ставятся в случаях если есть больше 1 действия

      LambdaExample.sortLambda(personList,
	      p -> p.getCountry().equals("Spain"),
	      pp -> {
		 pp.setCountry("Russia");
		 System.out.println(pp);
	      },
	      p -> p.length());
   }
}

//Интерфейс только с абстрактным 1 методом называется функциональным интерфейсом
@FunctionalInterface
interface Predicato<T> {
   boolean test(T t);

}

interface Consumerito<T> {
   void accept(T t);
}

class LambdaExample {
   public static void sortLambda(List<Person> personList,
				 Predicato<Person> p,
				 Consumerito<Person> c,
				 Function<String, Integer> f) {

//      for (Person person : personList) {
//	 if (p.test(person)) System.out.println(person);
//      }

      for (Person person : personList) {
	 if (p.test(person)) c.accept(person);
	 f.apply(person.getCountry());
      }
   }

}
