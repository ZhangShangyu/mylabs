package org.zsy.sometest;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestMap {

    @Test
    public void testCollectionViewModify() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 1);
        Collection<Integer> c = map.values();

        //java.util.HashMap.Values.remove --> java.util.AbstractCollection.remove
        // --> java.util.HashMap.Values.iterator --> java.util.HashMap.HashIterator.remove
        // collection view remove 元素 map中的对应entry也会被移除
        c.removeAll(Collections.singletonList(1));
        Assert.assertEquals(1, map.size());

        map.put(1, 1);
        map.put(3, 1);
        // 只能remove一个entry
        c.remove(1);

        // c.add(3); java.lang.UnsupportedOperationException
        Assert.assertEquals(2, map.size());
        System.out.println(map);
    }

}
