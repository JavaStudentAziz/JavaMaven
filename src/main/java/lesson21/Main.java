package lesson21;

import ApiLesson.Person;
import ApiLesson.PersonApi;

import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        //ДЗ
        //1)
        List<Person> personList = PersonApi.getPersonFromApi(100);

        for (Person person : personList) {
            System.out.println(person);
        }

        System.out.println("___________________________________________________________________________________________");

        //2) раскидать гендерно и получить 2 листа с мужчинами и женщинами
        List<Person> maleList =
                personList.stream()
                .filter(person -> person.getGender().equals("male"))
                .toList();

        maleList.forEach(System.out::println);

        System.out.println("___________________________________________________________________________________________");

        List<Person> femaleList =
                personList.stream()
                .filter(person -> person.getGender().equals("female"))
                .toList();

        femaleList.forEach(System.out::println);

        System.out.println("___________________________________________________________________________________________");

        //3) от этих листов, так же найти самого взрослого и молодого Person, Вывести
        System.out.println("Cамый старший среди мужчин: " +
                maleList.stream()
                        .max(Comparator.comparing(Person::getAge))
                        .get()
        );

        System.out.println("Cамая старшая среди женщин: " +
                femaleList.stream()
                        .max(Comparator.comparing(Person::getAge))
                        .get()
        );

        System.out.println("Cамый молодой среди мужчин: " +
                maleList.stream()
                        .min(Comparator.comparing(Person::getAge))
                        .get()
        );

        System.out.println("Cамая молодая среди женщин: " +
                femaleList.stream()
                        .min(Comparator.comparing(Person::getAge))
                        .get()
        );

        System.out.println("___________________________________________________________________________________________");

        //4) посчитать количество элементов в каждом списке
        System.out.println("Количество мужчин в списке: " +
                maleList.stream()
                        .count());

        System.out.println("Количество женщин в списке: " +
                femaleList.stream()
                        .count());

        System.out.println("___________________________________________________________________________________________");

        //5) вывести средний возраст мужчин и отдельно средний возраст женщин
        System.out.println("Cредний возраст мужчин: " +
                maleList.stream()
                        .mapToInt(Person::getAge)
                        .summaryStatistics()
                        .getAverage()
        );

        System.out.println("Cредний возраст женщин: " +
                femaleList.stream()
                        .mapToInt(Person::getAge)
                        .summaryStatistics()
                        .getAverage()
        );

        System.out.println("___________________________________________________________________________________________");

        //6) посчитать общий возраст для каждого списка
        System.out.println("Общий возраст мужчин: " +
                maleList.stream()
                        .mapToInt(Person::getAge)
                        .reduce(0, Integer::sum)
                );
        System.out.println("Общий возраст женщин: " +
                femaleList.stream()
                        .mapToInt(Person::getAge)
                        .reduce(0, Integer::sum)
        );
    }
}
