package middleware.rpc;

public class EchoServiceImpl implements EchoService {

    @Override
    public void echo(String address) {
        System.out.println("RPC: ping " + address + " is ok");
    }

}
