package com.example.application.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Service
public class RestClientService  implements Serializable {

    @Value("${api.baseurl}")
    private String baseURL;

    public List<AppDTO> getAllApps() {
        System.out.println("Fetching all apps objects through REST");
        final WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(baseURL + "apps");
        final List<AppDTO> apps = spec.retrieve().toEntityList(AppDTO.class).block().getBody();
        System.out.println(String.format("...received %d items", apps.size()));
        return apps;
    }
}
