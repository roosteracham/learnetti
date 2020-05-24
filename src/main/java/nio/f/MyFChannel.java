package nio.f;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyFChannel {

    public static void main(String[] args) {
        //readFile();

        writeFile();
        //ReadThenWrite();
    }

    private static void ReadThenWrite() {
        FileInputStream inputStream;
        FileOutputStream outputStream;
        try  {
            inputStream = new FileInputStream("src/a.txt");
            outputStream = new FileOutputStream("b.txt");
            FileChannel channel = inputStream.getChannel();
            FileChannel channel1 = outputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(10);
            int len = -1;
            while ((len = channel.read(buffer)) > -1) {
                buffer.flip();
                channel1.write(buffer);
                buffer.clear();
            }

            if (null != inputStream) {
                inputStream.close();
            }
            if (null != outputStream) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile() {
        byte[] bytes = "hello new world".getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        System.out.println("mark: " + buffer.mark() + " position: " + buffer.position() +
                " limit: " + buffer.limit() + " capacity: " + buffer.capacity());
        for (int i = 0; i < bytes.length; i++) {
            buffer.put(bytes[i]);
        }

        System.out.println("mark: " + buffer.mark() + " position: " + buffer.position() +
                " limit: " + buffer.limit() + " capacity: " + buffer.capacity());
        buffer.flip();

        System.out.println("mark: " + buffer.mark() + " position: " + buffer.position() +
                " limit: " + buffer.limit() + " capacity: " + buffer.capacity());
        try (FileOutputStream outputStream = new FileOutputStream("b.txt")) {
            FileChannel channel = outputStream.getChannel();
            channel.write(buffer);
            System.out.println("mark: " + buffer.mark() + " position: " + buffer.position() +
                    " limit: " + buffer.limit() + " capacity: " + buffer.capacity());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try  {
            InputStream inputStream = new FileInputStream("src/a.txt");

            FileChannel channel = ((FileInputStream) inputStream).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            channel.read(buffer);
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println((char)buffer.get());
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
