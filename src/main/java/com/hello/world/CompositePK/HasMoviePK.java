package com.hello.world.CompositePK;

import java.io.Serializable;
import java.util.Objects;

public class HasMoviePK implements Serializable {
    private String uid;
    private Integer mid;

    public HasMoviePK() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HasMoviePK pObject = (HasMoviePK) o;
        return Objects.equals(uid, pObject.uid) && Objects.equals(mid, pObject.mid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, mid);
    }
}
