package ru.otus.util;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class MethodCollect {
    private final List<Method> beforeMethods = new LinkedList<>();
    private final List<Method> testMethods = new LinkedList<>();
    private final List<Method> afterMethods = new LinkedList<>();

    public MethodCollect(Method[] methods) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(ru.otus.annotaition.Before.class)) {
                beforeMethods.add(method);
            }
            if (method.isAnnotationPresent(ru.otus.annotaition.Test.class)) {
                testMethods.add(method);
            }
            if (method.isAnnotationPresent(ru.otus.annotaition.After.class)) {
                afterMethods.add(method);
            }
        }
    }

    public List<Method> getBeforeMethods() {
        return beforeMethods;
    }

    public List<Method> getTestMethods() {
        return testMethods;
    }

    public List<Method> getAfterMethods() {
        return afterMethods;
    }
}
