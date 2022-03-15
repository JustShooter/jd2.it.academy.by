package by.academy.it.jd2.task02.model;

import by.academy.it.jd2.task02.model.parts.enums.RobotParts;
import by.academy.it.jd2.task02.model.parts.parent.Part;
import by.academy.it.jd2.task02.service.PartService;

import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

public class Dump {

    private final CyclicBarrier barrier = new CyclicBarrier(3);
    private final Random random = new Random();
    private static final int INITIAL_VALUE = 20;
    private final Queue<Part> partQueue;

    public Dump(Queue<Part> partQueue) {
        this.partQueue = partQueue;
        initializeDump();
        System.out.println(partQueue);
    }

    private void initializeDump() {
        for (int i = 0; i < INITIAL_VALUE; i++) {
            partQueue.add(PartService.create(RobotParts.values()[random.nextInt(RobotParts.values().length)]));
        }
    }

    public void addPartToDump(int qty) throws InterruptedException, BrokenBarrierException {
        synchronized (this) {
            for (int i = 0; i < qty; i++) {
                partQueue.add(PartService.create(RobotParts.values()[random.nextInt(RobotParts.values().length)]));
            }
        }
        barrier.await();
        Thread.sleep(100);
    }

    public void takePartsFromDump(int qty, Map<Part, Integer> partIntegerMap)
            throws InterruptedException, BrokenBarrierException {
        synchronized (this) {
            for (int i = 0; i < qty; i++) {
                if (!partQueue.isEmpty()) {
                    Part part = partQueue.poll();
                    Integer x = partIntegerMap.get(part) + 1;
                    partIntegerMap.replace(part, x);
                } else {
                    break;
                }
            }
        }
        barrier.await();
        Thread.sleep(100);
    }
}
