package com.development.task1.entity;

import java.util.Arrays;

public class CustomArray {
    private double[] array;

    public CustomArray() {

    }

    public CustomArray(double... array) {
        this.array = array;
    }

    public double[] getArray() {
        return array.clone();
    }

    public void setArray(double[] array) {
        this.array = array;
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
        return that.array == array;
    }

    @Override
    public int hashCode() {
        return 31 + (array == null ? Arrays.hashCode(array) : 0);
    }

    @Override
    public String toString() {
        Class<?> currentClass = this.getClass();
        return currentClass.getSimpleName() + "{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

}
