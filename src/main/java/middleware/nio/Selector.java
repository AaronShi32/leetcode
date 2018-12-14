package middleware.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 用单个线程来处理多个Channels
 */
public class Selector {

    public static void main(String[] args) throws IOException {

        java.nio.channels.Selector selector = java.nio.channels.Selector.open();

        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);

        SelectionKey key = channel.register(selector, SelectionKey.OP_READ); // 将 channel 注册到 SelectionKey 上

        while(true){
            int readyChannels = selector.select(); //阻塞
            if(readyChannels == 0){
                continue;
            }
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()){
                key = (SelectionKey) keyIterator.next();
                if(key.isAcceptable()){
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()){
                    // a connection was established with a remote server.
                } else if (key.isReadable()){
                    // a channel is ready for reading
                } else if (key.isWritable()){
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }







    }
}
