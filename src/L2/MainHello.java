package L2;

import L2.Model.HelloWorld;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainHello {
    public static void main(String[] args) {
        Class<HelloWorld> hello = HelloWorld.class;
        HelloWorld world = new HelloWorld();
        try {
            Method method = hello.getDeclaredMethod("printHelloWorld");
            method.setAccessible(true);
            method.invoke(world);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
