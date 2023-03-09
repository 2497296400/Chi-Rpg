import github.javaguide.FuckService;
import github.javaguide.HelloService;
import github.javaguide.annotation.RpcScan;
import github.javaguide.config.RpcServiceConfig;
import github.javaguide.remoting.transport.netty.server.NettyRpcServer;
import github.javaguide.serviceimpl.FuckImpl;
import github.javaguide.serviceimpl.HelloServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Server: Automatic registration service via @RpcService annotation
 *
 * @author shuang.kou
 * @createTime 2020年05月10日 07:25:00
 */
@RpcScan(basePackage = {"github.javaguide"})
public class NettyServerMain {
    public static void main(String[] args) {
        // Register service via annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyServerMain.class);
        NettyRpcServer nettyRpcServer = (NettyRpcServer) applicationContext.getBean("nettyRpcServer");
        // Register service manually
        HelloService helloService2 = new HelloServiceImpl2();
        FuckService fuckService= new FuckImpl();
        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                .group("test2").version("version2").service(helloService2).build();
        RpcServiceConfig rpcServiceConfig2 = RpcServiceConfig.builder()
                .group("test2").version("version2").service(fuckService).build();
        nettyRpcServer.registerService(rpcServiceConfig);
        nettyRpcServer.registerService(rpcServiceConfig2);
        nettyRpcServer.start();
    }
}
