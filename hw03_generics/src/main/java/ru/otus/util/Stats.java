package ru.otus.util;

public class Stats {
    private int passed = 0;
    private int fail = 0;
    private int all = 0;

    public void incrementPassed() {
        passed++;
        all++;
    }

    public void incrementFail() {
        fail++;
        all++;
    }

    public int getPassed() {
        return passed;
    }

    public int getFail() {
        return fail;
    }

    public int getAll() {
        return all;
    }
}
