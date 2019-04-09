package org.zsy.sometest.enumdemo;

public enum  EnumDemo {
    PLATFORM(1) {
        @Override
        int getAbValue() {
            return getValue() + 1;
        }
    },
    SELLER(2) {
        @Override
        int getAbValue() {
            return getValue() + 2;
        }
    };

    //初始字段
    private final int value;

    private EnumDemo(int value) {
        this.value = value;
    }

    //定义抽象方法
    abstract int getAbValue();

    //实例方法
    public int getValue() {
        return value;
    }

    //类方法
    public static EnumDemo findByValue(int value) {
        switch (value) {
            case 1:
                return PLATFORM;
            case 2:
                return SELLER;
            default:
                return null;
        }
    }

    enum SimpleEnum {
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        EnumDemo e = EnumDemo.findByValue(1);
        System.out.println(e.ordinal());
    }
}
