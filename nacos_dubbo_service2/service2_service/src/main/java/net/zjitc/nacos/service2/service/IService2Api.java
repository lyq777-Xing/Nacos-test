package net.zjitc.nacos.service2.service;

import net.zjitc.nacos.service2.api.Service2Api;
import org.apache.dubbo.config.annotation.Service;

@Service(interfaceClass = Service2Api.class)
public class IService2Api implements Service2Api {
    @Override
    public String dubboService2() {
        return "aaa";
    }
}
