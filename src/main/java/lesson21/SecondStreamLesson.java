package lesson21;

import ApiLesson.Person;
import ApiLesson.PersonApi;

import java.util.List;
import java.util.stream.Stream;

public class SecondStreamLesson {

    public static void main(String[] args) {

        List<Person> personList = PersonApi.getPersonFromApi(10);

        for (Person person : personList) {
            System.out.println(person);
        }
        System.out.println("__________________________________________________________________________________________");

        /** метод reduce
         *  выполняет заданные операции для листа элементов
         *  аккумулятор принимает значение элементов листа
         */
        System.out.println(personList.stream()
                .map(person -> person.getAge())
                .reduce(0, (acc, x) -> acc + x));

        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7)
                .reduce(0, (acc, x) -> acc + x));

        System.out.println("__________________________________________________________________________________________");

        /** метод sorted
         *  сортирует элементы о1,о2 листа
         */
        personList.stream()
                .sorted((o1, o2) -> {
                    if (!o1.getName().equals(o2.getName()))
                        return o1.getName().compareTo(o2.getName());
                    return 0;
                })
                .forEach(System.out::println);

        System.out.println("__________________________________________________________________________________________");

        /** метод concat
         *  объединяет два листа
         */
        Stream.concat(Stream.of(1, 2, 3), Stream.of(3, 4, 5))
                .forEach(System.out::println);

        System.out.println("__________________________________________________________________________________________");

        /** метод distinct
         *  удаляет дубли
         */
        Stream.concat(Stream.of(1, 2, 3), Stream.of(3, 4, 5))
                .distinct()
                .forEach(System.out::println);

        System.out.println("__________________________________________________________________________________________");

        /** метод peek
         *  ленивый промежуточный метод, алтернатива forEach
         */
        Stream.concat(Stream.of(1, 2, 3), Stream.of(3, 4, 5))
                .peek(System.out::println)
                .count();

        System.out.println("__________________________________________________________________________________________");

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
                .skip(3)
                .limit(7)
                .mapToInt(m -> m)
                .average()
                .ifPresent(System.out::println);

        System.out.println("___________________________________________________________________________________________");

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("___________________________________________________________________________________________");

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("___________________________________________________________________________________________");

    }
}
