package com.lxm.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${spring.application.name}")
    private String applicationName;

    public String getEurekaServer() {
        return eurekaServer;
    }

    public void setEurekaServer(String eurekaServer) {
        this.eurekaServer = eurekaServer;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @GetMapping("/config")
    public ConfigClientController configClientController() {
        ConfigClientController configClientController = new ConfigClientController();
        configClientController.setApplicationName(this.applicationName);
        configClientController.setEurekaServer(this.eurekaServer);
        return configClientController;
    }

    @Override
    public String toString() {
        return "ConfigClientController{" +
                "eurekaServer='" + eurekaServer + '\'' +
                ", applicationName='" + applicationName + '\'' +
                '}';
    }
}
