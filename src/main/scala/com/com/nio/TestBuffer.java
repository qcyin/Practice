package com.com.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * capacity:容量，表示缓冲区中最大存储数据的容量。一旦声明不能更改
 * limit:界限，表示缓冲区中可以操作数据的大小。（limit后数据不能进行读写）
 * position:位置，表示缓冲区正在操作数据的位置。
 *
 *
 * mark <= position <= limit <= capacity
 *
 * mark:标记，记录当前position的位置，初始值-1，
 * rewind()\flip()会让mark重新初始化
 * 可以通过reset()让position恢复到mark的位置,
 * position不可resset到-1位置
 *
 */
public class TestBuffer {

    @Test
    public void test2(){
        String str = "123456";

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(str.getBytes());

        buffer.flip();

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes,0,2);
        System.out.println(new String(bytes));
        System.out.println(buffer.position());

        //标记
        buffer.mark();

        buffer.get(bytes,2,2);
        System.out.println(new String(bytes));
        System.out.println(buffer.position());

        buffer.reset();
        System.out.println("mark--->"+buffer.position());

    }



    @Test
    public void test1(){

        String str = "123456";

        //1.分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("=====allocate=====");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //2.写入数据
        buffer.put(str.getBytes());
        System.out.println("=====put=====");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.mark();

        buffer.put("abc".getBytes());

        buffer.flip();

//        buffer.reset();


        buffer.put(str.getBytes());


        //3.切换操作模式
        buffer.flip();
        System.out.println("=====flip=====");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        byte[] bytes = new byte[buffer.limit()];
        //4.读取数据
        buffer.get(bytes);

        System.out.println("data----->"+new String(bytes));

        System.out.println("=====get=====");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //5.可重复
        buffer.rewind();
        System.out.println("=====rewind=====");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //6.清空，数据还存在，处于被遗忘状态
        buffer.clear();
        System.out.println("=====clear=====");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
    }
}
