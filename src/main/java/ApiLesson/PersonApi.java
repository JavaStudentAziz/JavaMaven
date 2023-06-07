package ApiLesson;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersonApi {
   public static Person getPersonFromApi() {

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
	      .uri(URI.create("https://randomuser.me/api"))
	      .GET()
	      .build();

      try {

	 HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	 Person person = parseJsonToPerson(response);
	 return person;

      } catch (Exception e) {
	 e.printStackTrace();
      }

      return null;
   }

   public static Person parseJsonToPerson(HttpResponse<String> response) {

      JSONObject object = new JSONObject(response.body())
	      .getJSONArray("results")
	      .getJSONObject(0);

      Person res = new Person();

      /** Импортировал и использовал класс DateTimeFormatter, чтобы парсить формат времени в определенном заданном ключе
       *  метод .ofPattern() позволяет задать шаблон, по которому форматируются полученные данные
       *  в документации узнал какие символы используют для определенных мер измерения времени:
       *  yyyy - год, ММ - месяц, dd - дни, HH - часы, mm - минуты, ss - секунды, SSS - милисекунды, в 'T' значения не парсящиеся как Date
       *  далее создал Строковую переменную dateOfBirth, в которую сохранил данные даты с json
       */
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      String dateOfBirth = object.getJSONObject("dob").getString("date");

      res.setName(object.getJSONObject("name").getString("first"));
      res.setLastName(object.getJSONObject("name").getString("last"));
      res.setCountry(object.getJSONObject("location").getString("country"));
      res.setUsername(object.getJSONObject("login").getString("username"));
      res.setPassword(object.getJSONObject("login").getString("password"));

      /** Метод parse() класса LocalDateTime использую для получения экземпляра LocalDateTime из строки, переданной в качестве параметра
       *  передаю в него нашу строку и formatter как модуль форматирования имеющихся данных
       *  Возвращаемое значение: этот метод возвращает LocalDateTime, который является проанализированным локальным значением даты и времени
       */
      res.setDateOfBirthday(LocalDateTime.parse(dateOfBirth, formatter));

      return res;
   }

   public static List<Person> getPersonFromApi(int count) {

      List<Person> personList = new ArrayList<>();
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
	      .uri(URI.create("https://randomuser.me/api"))
	      .GET()
	      .build();

      try {

	 for (int i = 0; i < count; i++) {

	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    Person person = parseJsonToPerson(response);
	    personList.add(person);

	 }

	 return personList;

      } catch (Exception e) {
	 e.printStackTrace();
      }

      return null;

   }

   public static List<Person> getPersonList(int count) {

      String formatOfApi = String.format("https://randomuser.me/api?results=%d", count);

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
	      .uri(URI.create(formatOfApi))
	      .GET()
	      .build();

      try {

	 HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	 return parsePersonList(response);

      } catch (Exception e) {
	 e.printStackTrace();
      }

      return null;
   }

   public static List<Person> parsePersonList(HttpResponse<String> response) {

      List<Person> personList = new ArrayList<>();

      int count = new JSONObject(response.body())
	      .getJSONObject("info")
	      .getInt("results");

      for (int i = 0; i < count; i++) {

	 JSONObject object = new JSONObject(response.body())
		 .getJSONArray("results")
		 .getJSONObject(i);

	 Person res = new Person();

	 res.setName(object.getJSONObject("name").getString("first"));
	 res.setLastName(object.getJSONObject("name").getString("last"));
	 res.setCountry(object.getJSONObject("location").getString("country"));
	 res.setUsername(object.getJSONObject("login").getString("username"));
	 res.setPassword(object.getJSONObject("login").getString("password"));
	 res.setDateOfBirthday(ZonedDateTime.parse(object.getJSONObject("dob").getString("date")).toLocalDateTime());

	 personList.add(res);
      }

      return personList;
   }
}
