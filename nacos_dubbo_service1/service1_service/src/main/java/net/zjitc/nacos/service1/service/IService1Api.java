package net.zjitc.nacos.service1.service;

import net.zjitc.nacos.service1.api.Service1Api;
import net.zjitc.nacos.service2.api.Service2Api;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

@Service
public class IService1Api implements Service1Api {
    @Reference
    Service2Api service2Api;

    @Override
    public String dubboService1() {
        return service2Api.dubboService2() ;
    }
}
