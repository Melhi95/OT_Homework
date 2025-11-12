package ru.otus;

public class Calculate {

    public int add(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        /* commented out for testing
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
         */
        return a / b;
    }
}
