import github.javaguide.FuckService;
import github.javaguide.HelloService;
import github.javaguide.config.RpcServiceConfig;
import github.javaguide.remoting.transport.socket.SocketRpcServer;
import github.javaguide.serviceimpl.FuckImpl;
import github.javaguide.serviceimpl.HelloServiceImpl;

/**
 * @author shuang.kou
 * @createTime 2020年05月10日 07:25:00
 */
public class SocketServerMain {
    public static void main(String[] args) {
        FuckService fuckService = new FuckImpl();
        SocketRpcServer socketRpcServer = new SocketRpcServer();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        rpcServiceConfig.setService(fuckService);
        socketRpcServer.registerService(rpcServiceConfig);
        socketRpcServer.start();
    }
}
