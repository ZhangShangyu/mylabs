package org.zsy.sometest;

import org.junit.Test;
import org.zsy.sometest.generic.Building;
import org.zsy.sometest.generic.Generic;
import org.zsy.sometest.generic.House;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class TestGeneric {

    @Test
    public void TestTypeParam() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList = Generic.fromArrayToList(intArray, Object::toString);
        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }


    @Test
    public void givenSubTypeOfWildCardBoundedGenericType_thanPaintingOK() {
        try {
            List<Building> subBuildingsList = new ArrayList<>();
            subBuildingsList.add(new Building());
            subBuildingsList.add(new House());
            // prints
            // Painting Building
            // Painting House
            Generic.paintAllBuildings(subBuildingsList);
        } catch (Exception e) {
            fail();
        }
    }
}
