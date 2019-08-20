package com.com.nio;

import org.junit.Test;

import java.nio.channels.Selector;

public class TestSelector {

    @Test
    public void test1() throws Exception {
        Selector selector = Selector.open();
    }
}
