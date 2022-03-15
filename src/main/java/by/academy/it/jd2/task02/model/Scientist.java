package by.academy.it.jd2.task02.model;

import by.academy.it.jd2.task02.model.parts.enums.RobotParts;
import by.academy.it.jd2.task02.model.parts.parent.Part;
import by.academy.it.jd2.task02.service.PartService;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;

public class Scientist implements Runnable {
    private final List<Robot> robots = new ArrayList<>();
    private final Dump dump;
    private final Random random = new Random();
    private final Map<Part, Integer> partIntegerMap = new HashMap<>();

    public Scientist(Dump dump) {
        this.dump = dump;
        for (int i = 0; i < RobotParts.values().length; i++) {
            partIntegerMap.put(PartService.create(RobotParts.values()[i]), 0);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int partsQty = random.nextInt(4) + 1;
            try {
                dump.takePartsFromDump(partsQty, partIntegerMap);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            tryToCreateRobot();
        }
    }

    private void tryToCreateRobot() {
        if (Collections.min(partIntegerMap.values()) != 0) {
            decrementEachOnePart();
            robots.add(new Robot());
            System.out.println(Thread.currentThread().getName() +
                    " created Robot! Total robots is " +
                    robots.size());
        }
    }

    private void decrementEachOnePart() {
        for (int i = 0; i < RobotParts.values().length; i++) {
            Integer x = partIntegerMap.get(PartService.create(RobotParts.values()[i])) - 1;
            Part part = PartService.create(RobotParts.values()[i]);
            partIntegerMap.put(part, x);
        }
    }

    public int checkRobotsQty() {
        return robots.size();
    }
}
