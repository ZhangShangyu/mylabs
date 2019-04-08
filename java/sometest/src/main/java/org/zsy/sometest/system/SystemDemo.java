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
}
