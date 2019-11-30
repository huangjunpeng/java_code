package com.xysports.realtime;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFielChannel {
    public static void main(String[] args) {
        String path = "D:\\huawei_kvm_debug.log";
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            FileChannel channel = raf.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(100);

            int bytesRead = channel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = channel.read(buf);
            }

            raf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
