package ApiLesson;


import java.time.LocalDateTime;
import java.util.Objects;

public class Person {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = LocalDateTime.now().getYear() - getDateOfBirthday().getYear();
    }

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String name;
    private String lastName;
    private String country;
    private LocalDateTime dateOfBirth;
    private String username;
    private String password;

    public Person() {
    }

    public Person(String name, String lastName, String country, LocalDateTime dateOfBirthday, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.dateOfBirth = dateOfBirthday;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirth;
    }

    public void setDateOfBirthday(LocalDateTime dateOfBirthday) {
        this.dateOfBirth = dateOfBirthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(country, person.country) && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(username, person.username) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, gender, age, country, dateOfBirth, username, password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", country='" + country + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
