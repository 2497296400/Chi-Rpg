package github.javaguide;

import github.javaguide.annotation.RpcReference;
import org.springframework.stereotype.Component;

/**
 * @author smile2coder
 */
@Component
public class HelloController {

    @RpcReference(version = "version1", group = "test1")
    private HelloService helloService;

    @RpcReference(version = "version1", group = "test1")
    private FuckService fuckService;

    public void test() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            System.out.println(fuckService.fuck("辉"));
        }
    }
}
