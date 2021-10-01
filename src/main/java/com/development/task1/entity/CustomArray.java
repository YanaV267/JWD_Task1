package com.development.task1.entity;

import java.io.Serializable;
import java.util.Arrays;

public class CustomArray implements Serializable {
    private double[] array;

    public CustomArray() {

    }

    public CustomArray(double... array) {
        this.array = array;
    }

    public double[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(double[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        return Arrays.compare(that.array, array) == 0;
    }

    @Override
    public int hashCode() {
        return 31 + (array == null ? 0 : Arrays.hashCode(array));
    }

    @Override
    public String toString() {
        Class<?> currentClass = this.getClass();
        return currentClass.getSimpleName() + "{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

}
