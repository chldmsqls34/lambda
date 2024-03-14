package com.linus.api.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    @Test
    public void systemOut(){
        Item s = new Item();
        String s3 = s.systemOut();
        System.out.println("-->"+s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(),s2);

    }
    @Test
    public void add() {
        Item a = new Item();
        int a2 = a.add(2,3);
        System.out.println(a2);
        int a3 = 5;
        Assertions.assertEquals(a2,a3);
    }
}