package skill.nio;

import java.nio.ByteBuffer;

/**
 * Gathering Writes (聚合)
 *
 * Channel 间的操作
 *
 * 能较好的处理动态消息
 */
public class Gather {

    public static void main(String[] args){
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        //write data into buffers
        ByteBuffer[] bufferArray = { header, body };
        //channel.write(bufferArray);
    }
}
