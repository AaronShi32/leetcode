package middleware.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Buffer
 * 允许写入: char, short, int, long, float 或 double
 * 关键属性: capacity, position, limit
 * buf.flip() 写 -> 读
 * buf.rewind() 重新读 postion -> 0, 清除 mark
 * buf.clear() 清除所有内容, 读 -> 写
 * buf.compact() 清空缓冲区已读内容, 读 -> 写
 */
public class Channel {

    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("src/main/resources/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while(bytesRead != -1){
            System.out.println("Read " + bytesRead);
            buf.flip(); // 将写模式转成读模式
            while(buf.hasRemaining()){
                // buf.rewind(); // 重新读
                System.out.println((char) buf.get());
            }
            buf.clear(); // 清空缓冲区所有内容, 转换成写模式
            // buf.compact(); // 清空缓冲区已读内容, 转换成写模式
            bytesRead = inChannel.read(buf);
        }

        aFile.close();

    }
}
