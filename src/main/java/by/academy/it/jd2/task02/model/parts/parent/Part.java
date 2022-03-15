package by.academy.it.jd2.task02.model.parts.parent;

import java.util.Objects;

public abstract class Part {
    public static String NAME;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME);
    }

    @Override
    public String toString() {
        return NAME;
    }
}
