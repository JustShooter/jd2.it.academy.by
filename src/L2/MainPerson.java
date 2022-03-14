package L2;

import L2.Model.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainPerson {
    public static void main(String[] args) {
        Class personClass = Person.class;
        Person person = new Person();

        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods
        ) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations
            ) {
                if (annotation.annotationType().equals(AcademyInfo.class)) {
                    try {
                        System.out.println(method.invoke(person));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}


