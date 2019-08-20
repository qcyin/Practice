package com.com.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {


    @Test
    public void test2() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\yinqicheng\\Desktop\\孤儿.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\yinqicheng\\Desktop\\孤儿孤儿.txt",true);

        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        copyData(fisChannel,fosChannel);

        fisChannel.close();
        fosChannel.close();
    }


    private void copyData(FileChannel fisChannel, FileChannel fosChannel) throws Exception{

        System.out.println("==============");
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        int i=0;
        while (fisChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            System.out.println(byteBuffer.toString()+(i++));
            while (byteBuffer.hasRemaining()){
                fosChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }

    }


    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\yinqicheng\\Desktop\\孤儿.txt");

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileChannel fisChannel = fis.getChannel();

        fisChannel.read(byteBuffer);

        System.out.println(byteBuffer);

        byte[] bytes = new byte[1024];
        byteBuffer.flip();

        byteBuffer.get(bytes,byteBuffer.position(),byteBuffer.remaining());

        System.out.println(new String(bytes,"gbk"));

        System.out.println(byteBuffer);

        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(byteBuffer.capacity());


        System.out.println(byteBuffer);

        fisChannel.close();
        fis.close();

    }
}
