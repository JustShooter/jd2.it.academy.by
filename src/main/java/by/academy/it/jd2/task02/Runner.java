package by.academy.it.jd2.task02;

import by.academy.it.jd2.task02.model.Dump;
import by.academy.it.jd2.task02.model.Plant;
import by.academy.it.jd2.task02.model.Scientist;
import by.academy.it.jd2.task02.model.parts.parent.Part;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Runner {

    public static final int SLEEP_TIME = 100;

    public static void main(String[] args) {

        Queue<Part> queue = new LinkedBlockingQueue<>();
        Dump dump = new Dump(queue);
        Thread plant = new Thread(new Plant(dump));
        Scientist sc1 = new Scientist(dump);
        Thread scientist1 = new Thread(sc1,"Scientist1");
        Scientist sc2 = new Scientist(dump);
        Thread scientist2 = new Thread(sc2,"Scientist2");

        plant.start();
        scientist1.start();
        scientist2.start();

        try {
            while (plant.isAlive() &&
            scientist1.isAlive() &&
            scientist2.isAlive()){
                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.println("Scientist 1 robots qty is " + sc1.checkRobotsQty());
        System.out.println("Scientist 2 robots qty is " + sc2.checkRobotsQty());
        if (sc1.checkRobotsQty() > sc2.checkRobotsQty()) {
            System.out.println("Scientist 1 wins");
        } else if (sc1.checkRobotsQty() < sc2.checkRobotsQty()){
            System.out.println("Scientist 2 wins");
        } else {
            System.out.println("Draw");
        }
    }

}
