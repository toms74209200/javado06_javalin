package com.example;

public class CalcResource {
    public static int exec(String exec, int a, int b) {
        switch (exec) {
            case "add":
                return add(a, b);
            case "diff":
                return diff(a, b);
            case "mul":
                return mul(a, b);
            case "div":
                return div(a, b);
            default:
                return 0;
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int diff(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) throws ArithmeticException {
        return a / b;
    }

}
