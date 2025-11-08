package ru.otus;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @SuppressWarnings("java:S106")
public class HelloOtus {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloOtus.class);
        String str = "Hello otus";
        str = Strings.padEnd(str, 13, '!');
        logger.info(str);
    }
}
