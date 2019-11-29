package by.it.advertproject.tester.examl.sololearn.increment.equalsexample;

import java.util.Objects;

public class ExampleEquals {
    int id;
    String name;
    double d;
    Double dDouble;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleEquals that = (ExampleEquals) o;
        return id == that.id &&
                Double.compare(that.d, d) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(dDouble, that.dDouble);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, d, dDouble);
    }
}
