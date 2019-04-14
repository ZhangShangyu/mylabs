package org.zsy.sometest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Fail-Safe Iterator vs Fail-Fast Iterator
 * https://www.baeldung.com/java-fail-safe-vs-fail-fast-iterator
 */

public class TestIterator {

    @Test(expected = ConcurrentModificationException.class)
    public void failFast1() {
        ArrayList<Integer> numbers = new ArrayList<Integer>() {{
            add(10);
            add(20);
            add(30);
        }};

        //获取迭代器时, expectedModCount初始化 = 容器modCount
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            // add后容器中modCount被修改
            numbers.add(40);
            // 容器modCount与迭代器expectedModCount不一致 抛异常
            iterator.next();
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void failFast2() {
        ArrayList<Integer> numbers = new ArrayList<Integer>() {{
            add(10);
            add(20);
            add(30);
            add(40);
        }};

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 30) {
                // will not throw Exception
                iterator.remove();
            }
        }
        System.out.println("using iterator's remove method = " + numbers);

        iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 40) {
                // will throw Exception on
                // next call of next() method
                numbers.remove(2);
            }
        }

    }

    /**
     * ConcurrentHashMap iterator 为fail-safe 在迭代时可以修改容器
     * 但是弱一致性的实现，不保证迭代结果和修改后的结果一致
     */
    @Test
    public void failSafe1() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>() {{
            put("First", 10);
            put("Second", 20);
            put("Third", 30);
            put("Fourth", 40);
        }};

        HashSet<String> iteKeys = new HashSet<>();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            //Fifth 这个key排在第一次迭代后，后续迭代还可以拿到这个key，所以是一致的
            map.put("Fifth", 50);
            iteKeys.add(key);
        }
        Assert.assertEquals(iteKeys.size(), map.size());


        Iterator<String> iterator2 = map.keySet().iterator();
        HashSet<String> iteKeys2 = new HashSet<>();
        while (iterator2.hasNext()) {
            String key = iterator2.next();
            // A 这个key排在第一次迭代前，迭代时略过了这个key，所以迭代拿到的key和map中所有的key不一致
            map.put("A", 50);
            iteKeys2.add(key);
        }
        Assert.assertTrue(iteKeys2.size() < map.size());

    }
}
