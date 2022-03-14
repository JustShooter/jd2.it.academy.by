package L2.scientists;

import java.util.Random;

public enum Parts {
    HEAD, BODY,LEFT_ARM,RIGHT_ARM,LEFT_LEG,RIGHT_LEG,CPU,RAM,HDD;

    public static Parts randomPart (){
        return Parts.values()[new Random().nextInt(Parts.values().length)];
    }


}
