package skill.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Java NIO 管道是2个 **线程** 之间的单向数据连接。
 *
 * Pipe有一个source通道和一个sink通道。
 *
 * 数据会被写到sink通道，从source通道读取
 */
public class Pipe {

    public static void main(String[] args) throws IOException {

        java.nio.channels.Pipe pipe = java.nio.channels.Pipe.open();

        java.nio.channels.Pipe.SinkChannel sinkChannel = pipe.sink();

        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }

        java.nio.channels.Pipe.SourceChannel sourceChannel = pipe.source();

        buf = ByteBuffer.allocate(48);

        int bytesRead = sourceChannel.read(buf);
    }

}
