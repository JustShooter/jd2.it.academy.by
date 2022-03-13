package by.academy.it.jd2.task02;

import by.academy.it.jd2.task02.model.parts.Part;
import by.academy.it.jd2.task02.model.parts.enums.RobotParts;
import by.academy.it.jd2.task02.service.PartService;
import by.academy.it.jd2.task02.service.PartServiceImpl;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Random random = new Random();
        PartService service = new PartServiceImpl();
        Part part = service.create(RobotParts.values()[random.nextInt(RobotParts.values().length)]); // Получение рандомной части...
        System.out.println(part);
    }

}
