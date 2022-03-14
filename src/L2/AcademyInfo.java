package L2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Задание 72
//Создать собственную аннотацию @AcademyInfo c полем year.
// Создать метод,  помеченный этой аннотацией с заданным year и метод без нее.
// С помощью рефлексии проверить наличие данной аннотации у этих методов из основной программы.

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AcademyInfo {
    int year();
}
