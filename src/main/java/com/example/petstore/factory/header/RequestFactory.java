package com.example.petstore.factory.header;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

import java.net.URI;

public final class RequestFactory {
    public static RequestFactory shared = new RequestFactory();

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public <T> RequestEntity<T> createRequest(HttpMethod method, String strUrl, T body) {
        HttpHeaders headers = this.createHeaders();
        URI url = URI.create(strUrl);
        return new RequestEntity<>(body, headers, method, url);
    }
}
