package com.liuweihua.littlerecord;

import com.liuweihua.littlerecord.service.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class LittleRecordApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(LittleRecordApplication.class);
        Map<String, Object> grpcServiceBeanMap =  applicationContext.getBeansWithAnnotation(GrpcService.class);
        ServiceManager serviceManager = applicationContext.getBean("serviceManager",ServiceManager.class);
        serviceManager.loadService(grpcServiceBeanMap);
    }
}
