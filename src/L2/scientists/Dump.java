package L2.scientists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dump {
    public static final int INITIAL_VALUE = 20;

    static List <Parts> dumpParts = new ArrayList<>();

    public void firstNight(){
        for(int i=0; i<INITIAL_VALUE;i++){
            dumpParts.add(Parts.randomPart());
        }
    }

    public void otherNights() {
        for (int i=0; i < new Random().nextInt(4); i++) {
            dumpParts.add(Parts.randomPart());
        }
    }

    public static void main(String[] args) {
        Dump dump = new Dump();
        dump.firstNight();
        System.out.println(Robot.robotsQuantity(dumpParts));
    }
}
