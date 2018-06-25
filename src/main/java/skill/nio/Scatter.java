package skill.nio;

import java.nio.ByteBuffer;

/**
 * Scattering Reads (分散)
 *
 * Channel 间的操作
 *
 * 适用于固定大小的消息
 */
public class Scatter {

    public static void main(String[] args){
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = { header, body };
        // channel.read(bufferArray);
    }
}
