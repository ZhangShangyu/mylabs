package org.zsy.sometest;

import org.junit.Assert;
import org.junit.Test;
import org.zsy.sometest.generic.Building;
import org.zsy.sometest.system.SystemDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSystem {

    @Test
    public void testArrayCopy() {
        Building[] source = {new Building(), new Building()};
        Building[] dest = new Building[2];
        SystemDemo.arrayCopy(source, dest);
        dest[0].data = 2;
        dest[1] = null;

        Assert.assertNotSame(source, dest);
        Assert.assertEquals(source[0].hashCode(), dest[0].hashCode());
        Assert.assertEquals(source[0].data, dest[0].data);
        Assert.assertNotNull(source[1]);
    }

    @Test
    public void testArraysCopyOf() {
        Building[] source = {new Building(), new Building()};
        Building[] dest = Arrays.copyOf(source, 2);
        dest[0].data = 2;
        dest[1] = null;

        Assert.assertNotSame(source, dest);
        Assert.assertEquals(source[0].hashCode(), dest[0].hashCode());
        Assert.assertEquals(source[0].data, dest[0].data);
        Assert.assertNotNull(source[1]);
    }


    @Test
    public void testArrayCopy2() {
        // string 为不可变类 所以虽然只copy了引用 但修改引用无影响
        String[] source = {"a", "b"};
        String[] dest = new String[2];
        SystemDemo.arrayCopy(source, dest);
        source[0] = "c";
        Assert.assertNotSame(source[0], dest[0]);
    }

    @Test
    public void testArraysCopyOf2() {
        String[] source = {"a", "b"};
        String[] dest = Arrays.copyOf(source, 2);
        source[0] = "c";
        Assert.assertNotSame(source[0], dest[0]);
    }


    @Test
    public void testArrayListToArray() {
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Building());
        Building[] pd = new Building[2];
        Building[] dest = buildings.toArray(pd);

        Building[] pd0 = new Building[0];
        Building[] dest0 = buildings.toArray(pd0);

        Assert.assertSame(pd, dest);
        Assert.assertNotSame(pd0, dest0);
    }


}
