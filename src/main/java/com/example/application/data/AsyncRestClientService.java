package com.example.application.data;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Service
public class AsyncRestClientService implements Serializable {
    /**
     * Generic callback interface for async operations
     *
     * @param <T> the result type
     */
    public static interface AsyncRestCallback<T> {
        void operationFinished(T results);
    }

    /**
     * Returns parsed {@link AppDTO} objects from the Rest service,
     * asynchronously
     */
    public void getAllAppsAsync(AsyncRestCallback<List<AppDTO>> callback) {
        System.out.println("Setting up fetching apps through REST...");

        RequestHeadersSpec<?> spec = WebClient.create().get().uri("https://innv8.lib.co.ke/api/v1/apps");

        // instead of 'block', do 'subscribe'
        // this means the fetch will run on a separate thread and notify us when its ready by calling our
        // lambda operation
        spec.retrieve().toEntityList(AppDTO.class).subscribe(result -> {
            final List<AppDTO> apps = result.getBody();
            System.out.println(String.format("... received %d items", apps.size()));
            System.out.println(apps);

            // call the ui with the data
            callback.operationFinished(apps);
        });

    }
}
