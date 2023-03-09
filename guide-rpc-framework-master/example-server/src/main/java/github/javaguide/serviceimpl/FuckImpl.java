package github.javaguide.serviceimpl;

import github.javaguide.FuckService;
import github.javaguide.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RpcService(group = "test1", version = "version1")
public class FuckImpl implements FuckService {

    @Override
    public String fuck(String name) {
      log.info("问候！{}",name);
      return name;
    }
}
