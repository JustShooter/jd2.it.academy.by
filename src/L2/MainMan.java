package L2;

import L2.Model.Man;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainMan {
    public static void main(String[] args) {
        Class<Man> manClass = Man.class;
        Man man = new Man();
        try {
            Method method = manClass.getDeclaredMethod("getInfo", Class.class, Man.class);
            method.setAccessible(true);
            method.invoke(man,manClass,man);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
