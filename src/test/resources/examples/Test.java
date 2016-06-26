package org.test;

public class Test {
    private static Integer field = 1000;

    public static void eval() {
        Integer val1 = 1000;
        Integer val2 = 1000;
        boolean equals = val1 == val2;
        System.out.println(equals);
    }

    public static void evalWithField() {
        Integer val = 1000;
        boolean equals = field == val;
        System.out.println(equals);
    }

    public static void evalWithArg(Integer arg) {
        Integer val = 1000;
        boolean equals = arg == val;
        System.out.println(equals);
    }

    public static void evalWithMethodInvocation() {
        Integer val = 1000;
        boolean equals = getInteger() == val;
        System.out.println(equals);
    }

    private static int getInteger() {
        return 1000;
    }

    public static void evalWithExternalMethodInvocation() {
        String s = "test";
        Integer val = 1000;
        boolean equals = s.length() == val;
        System.out.println(equals);
    }
}
