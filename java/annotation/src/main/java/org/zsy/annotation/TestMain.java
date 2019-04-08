package org.zsy.annotation;

import java.io.IOException;

@TestAnnotation(count = 123456)
public class TestMain {

    // javac TestAnnotation.java TestMain.java
    // javap -v TestAnnotation
    // java -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true TestMain

    public static void main(String[] args) throws IOException {
        TestAnnotation annotation = TestMain.class.getAnnotation(TestAnnotation.class);
        System.out.println(annotation.count());
        System.in.read();
    }

}