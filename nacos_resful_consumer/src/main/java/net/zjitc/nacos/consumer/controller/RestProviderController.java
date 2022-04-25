package net.zjitc.nacos.consumer.controller;

import net.zjitc.nacos.service2.api.Service2Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestProviderController {

    String serviceId = "nacos-restful-provider";

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/service")
    public String service(){
        ServiceInstance choose = loadBalancerClient.choose(serviceId);
        return "aaa";
    }

    @Reference
    Service2Api service2Api;

    @GetMapping("/service2")
    public String service2(){
        return service2Api.dubboService2();
    }

    @Value("${common.name}")
    private String common_name;
    @GetMapping("/configs")
    public String getValue(){
        return  common_name;
    }
}
