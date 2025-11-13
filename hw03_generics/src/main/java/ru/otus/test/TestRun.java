package ru.otus.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import ru.otus.util.MethodCollect;
import ru.otus.util.Stats;

public class TestRun<T> {
    public void test(Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Stats stats = new Stats();
        MethodCollect methodCollect = new MethodCollect(clazz.getDeclaredMethods());

        for (Method method : methodCollect.getTestMethods()) {
            T instance = clazz.getDeclaredConstructor().newInstance();

            runBeforeMethods(instance, methodCollect);
            runTestMethod(instance, method, stats);
            runAfterMethods(instance, methodCollect);
        }
        System.out.println("---Test results---");
        System.out.println("Passed: " + stats.getPassed());
        System.out.println("Failed: " + stats.getFail());
        System.out.println("Total: " + stats.getAll());
        System.out.println("-------------------");
    }

    private void runBeforeMethods(T instance, MethodCollect methodCollect) {
        for (Method beforeMethod : methodCollect.getBeforeMethods()) {
            try {
                System.out.println("-------------------");
                beforeMethod.invoke(instance);
            } catch (Exception e) {
                System.out.println("Before method failed: " + e.getCause());
            }
        }
    }

    private void runTestMethod(T instance, Method testMethod, Stats stats) {
        try {
            testMethod.invoke(instance);
            stats.incrementPassed();
            System.out.println("Test method: " + testMethod.getName());
            System.out.println("Test method passed");
        } catch (Exception e) {
            stats.incrementFail();
            System.out.println("Test method failed: " + e.getCause());
        }
    }

    private void runAfterMethods(T instance, MethodCollect methodCollect) {
        for (Method afterMethod : methodCollect.getAfterMethods()) {
            try {
                afterMethod.invoke(instance);
                System.out.println("-------------------");

            } catch (Exception e) {
                System.out.println("After method failed: " + e.getCause());
            }
        }
    }
}
