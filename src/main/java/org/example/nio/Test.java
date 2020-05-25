package org.example.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;

public class Test {

    public static void main(String[] args) {

        //test1();

        //charset();
    }

    private static void charset() {
        String s = "你好";
        ByteBuffer allocate = ByteBuffer.allocate(100);
        allocate.put(s.getBytes());
        allocate.flip();
        Charset charset = Charset.forName("unicode");

        CharBuffer decode = charset.decode(allocate);
        System.out.println((byte)decode.get(0) + ": " + decode.get(0));
        ByteBuffer encode = charset.encode(decode);
        System.out.println(new String(encode.array(), 0 , encode.array().length));
    }

    private static void test1() {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < 10; i++) {
            buffer.put(i);
        }
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
