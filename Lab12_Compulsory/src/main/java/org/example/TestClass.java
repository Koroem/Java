package org.example;

import org.testng.annotations.Test;

public class TestClass {

    @Test
    public static void testMethod1() {
        System.out.println("Method 1 is running");
    }

    @Test
    public static void testMethod2() {
        System.out.println("Method 2 is running");
    }

    public static void main(String[] args) {
        System.out.println("This is main method");
    }
}