package skill.rpc;

import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 服务发布(暴露)
 * java reflect
 */
public class RPCExporter {

    private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void export(String hostname, int port) throws IOException {

        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(hostname, port));

        try {

            while(true){
                executor.execute(new RPCTask(server.accept()));
            }

        }  finally {
            server.close();
        }

    }
}

class RPCTask implements Runnable {

    private Socket client;

    public RPCTask(Socket client){
        this.client = client;
    }

    @Override
    public void run() {

        ObjectInputStream input = null;
        ObjectOutputStream output = null;

        try {

            input = new ObjectInputStream(client.getInputStream());

            String interfaceName = input.readUTF();
            Class<?> service = Class.forName(interfaceName); // 类

            String methodName = input.readUTF(); // 方法名

            Class<?>[] parameterTypes = (Class<?>[]) input.readObject(); // 参数类型

            Object[] arguments = (Object[]) input.readObject(); // 参数

            Method method =  service.getMethod(methodName, parameterTypes); // 反射

            Object result = method.invoke(service.newInstance(), arguments); // 调用

            output = new ObjectOutputStream(client.getOutputStream());

            output.writeObject(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if(input != null){
                try {
                    input.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(output != null){
                try {
                    output.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(client != null){
                try {
                    client.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}
