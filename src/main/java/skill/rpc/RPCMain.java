package skill.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCMain {

    public static void main(String[] args){
        new Thread(() -> {
            try {
                RPCExporter.export("127.0.0.1", 8088);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        RPCImporter<EchoService> importer = new RPCImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("127.0.0.1", 8088));
        echo.echo("www.google.com");
    }

}
