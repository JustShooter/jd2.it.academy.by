package L2.Model;

//Создать класс Man c произвольным набором полей и методов (не менее 3) Создать метод,
// который распечатает информацию о классе с помощью рефлексии.
// Вызвать метод с помощью рефлексии из основной программы.

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.stream.Stream;

public class Man {
    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayMan() {
        System.out.println(name + " " + surname + " " + age);
    }

    private static void getInfo(Class manClass, Man man) {
        Field[] fields = manClass.getDeclaredFields();
        Stream.of(fields)
                .peek(field -> field.setAccessible(true))
                .peek(field -> {
                    try {
                        System.out.println(field.get(man));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                })
                .forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return age == man.age && Objects.equals(name, man.name) && Objects.equals(surname, man.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "name= " + name +
                "surname= " + surname +
                "age= " + age;
    }
}
