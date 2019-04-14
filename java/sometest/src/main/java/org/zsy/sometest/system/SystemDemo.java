package org.zsy.sometest.system;

import java.util.Map;
import java.util.Properties;

public class SystemDemo {

    public static void main(String[] args) {
        // 获取默认系统属性classpath等 及-D参数
        Properties d = java.lang.System.getProperties();
        System.out.println(d);
        // 获取环境变量
        Map<String, String> env = java.lang.System.getenv();
        System.out.println(env);

    }

    public static <T> void arrayCopy(T[] source, T[] dest) {
        //对于数组是深拷贝(栈引用copy了一份 但都指向同一个对象)，对于数组内的对象是浅拷贝
        System.arraycopy(source, 0, dest, 0, source.length);
    }

}
