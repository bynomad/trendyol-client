package com.configurationclient.client;

import com.configurationclient.model.ConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

@Component
public class ConfigurationReader {

    private final ConfigurationClient configurationClient;

    @Autowired
    public ConfigurationReader(ConfigurationClient configurationClient) {
        this.configurationClient = configurationClient;
    }

    private Set<ConfigResponse> configResponses;

    @Value("${application.name}")
    private String applicationName;

    @Value("${client.connection.string}")
    private String connectionString;

    @Value("${client.time.interval}")
    private Long timeInterval;


    public <T extends Serializable> T getValueFromFeign(String key) {
        return (T) configurationClient.getConfig(applicationName, key);
    }

    public <T extends Serializable> T getAllValueFromFeign() {
        return (T) configurationClient.getAllConfigByApplicationName(applicationName);
    }

    public <T> T getValueFromCache(String key) {
        for (ConfigResponse configResponse : configResponses) {
            if (configResponse.getName().equals(key)) {
                return (T) configResponse.getValue();
            }
        }
        return null;
    }

    @Scheduled(fixedRateString = "${client.time.interval}")
    public void getCurrentConfigurationList() {
        configResponses = configurationClient.getAllConfigByApplicationName(applicationName);
    }

}
