package com.soon83;

import lombok.SneakyThrows;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class LinkUtil {

    @SneakyThrows
    public static URI location(Long id) {
        String path = (id == null) ? "" : "/" + id;
        return getUri(path);
    }

    @SneakyThrows
    public static URI location(String token) {
        String path = (token == null) ? "" : "/" + token;
        return getUri(path);
    }

    private static URI getUri(String path) throws URISyntaxException {
        String requestUri = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
        return new URI(requestUri.substring(requestUri.indexOf("/", 8)) + path);
    }
}
