package by.it.advertproject.bean;

import java.io.Serializable;
import java.util.Objects;

public abstract class Bean implements Serializable, Cloneable {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bean)) return false;
        Bean bean = (Bean) o;
        return getId() == bean.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                '}';
    }
}
