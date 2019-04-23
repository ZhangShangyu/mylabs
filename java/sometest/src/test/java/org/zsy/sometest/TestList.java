package org.zsy.sometest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestList {


    @Test
    public void testToString() {
        List<Integer> l = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println(l.toString());
    }

    @Test
    public void testListIterator() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            it.add(0);
        }
        System.out.println(list);

        System.out.println("====================");

        boolean add = false;
        while (it.hasPrevious()) {
            System.out.println(it.previous());
            if (!add) {
                it.add(-1);
                add = true;
            }
        }
        System.out.println(list);
    }

    @Test
    public void testRemove() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(0);
        }};
        System.out.println("origin " + list);

        // 匹配index [0] removed  直接根据index 移动元素O(n)
        list.remove(0);
        System.out.println("after remove index " + list);
        Assert.assertEquals(1, (int) list.get(0));

        // 匹配容器内容 [?] == 0 removed
        // 遍历elements找到equals的元素 再移动元素 O(2n)
        list.remove(Integer.valueOf(0));
        System.out.println("after remove element " + list);
        Assert.assertEquals(1, (int) list.get(0));
    }
}
