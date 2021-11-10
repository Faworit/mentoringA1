package com.epam.ryabtsev.entity;

import java.util.Objects;

public class Entry {
    private String data;

    public Entry(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return Objects.equals(data, entry.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
