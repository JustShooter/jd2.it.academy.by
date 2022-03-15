package by.academy.it.jd2.task02.model;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Plant implements Runnable {
    private final Dump dump;
    private final Random random = new Random();

    public Plant(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int partsQty = random.nextInt(4) + 1;
            try {
                dump.addPartToDump(partsQty);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
