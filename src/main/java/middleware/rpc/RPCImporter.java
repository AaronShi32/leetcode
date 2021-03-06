package middleware.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * 服务调用(订阅)
 * java proxy
 */
public class RPCImporter<S> {

    public S importer(final Class<?> serviceClass, final InetSocketAddress addr){

        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass.getInterfaces()[0]},
                (proxy, method, args) -> {

                    Socket socket = null;

                    ObjectOutputStream output = null;
                    ObjectInputStream input = null;

                    try {
                        socket = new Socket();
                        socket.connect(addr);
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeUTF(serviceClass.getName());
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);
                        input = new ObjectInputStream(socket.getInputStream());
                        return input.readObject();
                    } finally {
                        if(socket != null){
                            socket.close();
                        }
                        if(input != null){
                            input.close();
                        }
                        if(output != null){
                            output.close();
                        }
                    }
                });
    }

}
