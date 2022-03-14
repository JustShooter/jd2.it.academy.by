package L2.Model;

import L2.AcademyInfo;

public class Person {
    private String name = "Nick";
    private int age = 20;

    @AcademyInfo(year = 5)
    public void printPerson() {
        System.out.println("Name person: " + name + "\n"
                + " Age person: " + age);
    }

    public void addAge() {
        System.out.println(age + 1);
    }


}
