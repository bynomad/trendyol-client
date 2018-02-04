package com.configurationclient.client;

import com.configurationclient.model.ConfigResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Component
@FeignClient(name = "configurationClient", url = "http://localhost:8080")
public interface ConfigurationClient {

    @GetMapping(value = "/api/config/{applicationName}/{key}")
    ConfigResponse getConfig(@PathVariable("applicationName") String applicationName, @PathVariable("key") String key);

    @GetMapping(value = "/api/config/{applicationName}")
    Set<ConfigResponse> getAllConfigByApplicationName(@PathVariable("applicationName") String applicationName);
}
