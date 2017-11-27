package com.athaydes.rawhttp.core;

import java.net.URI;
import java.net.URISyntaxException;

public class MethodLine {

    private final String method;
    private final URI uri;
    private final String httpVersion;

    public MethodLine(String method, URI uri, String httpVersion) {
        this.method = method;
        this.uri = uri;
        this.httpVersion = httpVersion;
    }

    public String getMethod() {
        return method;
    }

    public URI getUri() {
        return uri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public MethodLine withHost(String host) {
        try {
            URI newURI = new URI(uri.getScheme(), uri.getUserInfo(), host, uri.getPort(),
                    uri.getPath(), uri.getQuery(), uri.getFragment());
            return new MethodLine(method, newURI, httpVersion);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Cannot create new URI with host: " + host, e);
        }
    }

    @Override
    public String toString() {
        return method + " " + uri + " " + httpVersion;
    }
}