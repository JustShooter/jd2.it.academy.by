package by.academy.it.jd2.task02.service;

import by.academy.it.jd2.task02.model.parts.Part;
import by.academy.it.jd2.task02.model.parts.enums.RobotParts;

public interface PartService {
    Part create(RobotParts parts);
}
