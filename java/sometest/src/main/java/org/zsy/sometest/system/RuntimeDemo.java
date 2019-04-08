package org.zsy.sometest.system;

public class RuntimeDemo {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory()); // bytes
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        Thread t = new Thread(() -> System.out.println("in shut down hook"));
        Runtime.getRuntime().addShutdownHook(t);
    }
}
