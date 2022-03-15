package by.academy.it.jd2.task02.model;

import by.academy.it.jd2.task02.model.parts.*;
import by.academy.it.jd2.task02.model.parts.parent.Part;

import java.util.List;

public class Robot {
    private final List<Part> partList;

    public Robot() {
        partList = List.of(new Body()
                , new Head()
                , new LeftArm()
                , new RightArm()
                , new LeftLeg()
                , new RightLeg()
                , new CPU()
                , new RAM()
                , new HDD());
    }

    @Override
    public String toString() {
        return "Robot{" +
                "partList=" + partList +
                '}';
    }
}
