package by.academy.it.jd2.task02.service;

import by.academy.it.jd2.task02.model.parts.*;
import by.academy.it.jd2.task02.model.parts.parent.Part;
import by.academy.it.jd2.task02.model.parts.enums.RobotParts;

public interface PartService {
    static Part create(RobotParts parts) {
        switch (parts) {
            case BODY:
                return new Body();
            case CPU:
                return new CPU();
            case HDD:
                return new HDD();
            case HEAD:
                return new Head();
            case LEFT_HAND:
                return new LeftArm();
            case LEFT_LEG:
                return new LeftLeg();
            case RAM:
                return new RAM();
            case RIGHT_HAND:
                return new RightArm();
            case RIGHT_LEG:
                return new RightLeg();
            default:
                return null;
        }
    }
}
