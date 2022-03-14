package L2.scientists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static L2.scientists.Dump.dumpParts;

public class Assistant {
Dump dump;
    static List<Parts> scientistParts = new ArrayList<>();

public List<Parts> pickedParts(){
    for(int i=0; i<new Random().nextInt(4); i++){
        scientistParts.add(dumpParts.remove(i));
    }
    return scientistParts;
}
}
