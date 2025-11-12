package ru.otus;

import java.lang.reflect.InvocationTargetException;
import ru.otus.test.CalculateTest;
import ru.otus.test.TestRun;

public class Main {
    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        TestRun<CalculateTest> testRun = new TestRun<>();
        testRun.test(CalculateTest.class);
    }
}
