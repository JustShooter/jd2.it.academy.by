package by.academy.it.jd2.task02.model;

public class Scientist implements Runnable{

    private Dump dump;

    public Scientist(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        while (dump.getPart(1)) {
            System.out.println("^^^ Забираю со свалки ^^^");
        }
    }
}
