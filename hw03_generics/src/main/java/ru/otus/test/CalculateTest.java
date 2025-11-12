package ru.otus.test;

import ru.otus.Calculate;
import ru.otus.annotaition.After;
import ru.otus.annotaition.Before;
import ru.otus.annotaition.Test;

public class CalculateTest {
    Calculate c = new Calculate();

    @Before
    public void beforeMethod() {
        System.out.println("Test Start");
    }

    @Test
    public void testAdd() {
        if (c.add(1, 2) != 3) {
            throw new ArithmeticException("Addition test failed");
        }
    }

    @Test
    public void testDiv() {
        if (c.div(4, 2) != 2) {
            throw new ArithmeticException("Division test failed");
        }

        try {
            c.div(4, 0);
            throw new ArithmeticException("Division by zero test failed");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Division by zero test failed");
        }
    }

    @After
    public void afterMethod() {
        System.out.println("Test Stop");
    }
}
