package it.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ResObj {

    private Object args;
    private String data;
    private Object files;
    private Object form;
    private Header headers;


    public static class Header {
        @JsonProperty("Content-Length")
        private String contentLength;
        @JsonProperty("Host")
        private String host;
        @JsonProperty("User-Agent")
        private String userAgent;
        @JsonProperty("X-Amzn-Trace-Id")
        private String xAmznTraceId;

        public String getContentLength() {
            return contentLength;
        }

        public void setContentLength(String contentLength) {
            this.contentLength = contentLength;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }

        public String getxAmznTraceId() {
            return xAmznTraceId;
        }

        public void setxAmznTraceId(String xAmznTraceId) {
            this.xAmznTraceId = xAmznTraceId;
        }

        @Override
        public String toString() {
            return "Header{" +
                    "contentLength='" + contentLength + '\'' +
                    ", host='" + host + '\'' +
                    ", userAgent='" + userAgent + '\'' +
                    ", xAmznTraceId='" + xAmznTraceId + '\'' +
                    '}';
        }
    }

    private Map<String, String> json;
    private String origin;
    private String url;


    public Object getArgs() {
        return args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getFiles() {
        return files;
    }

    public void setFiles(Object files) {
        this.files = files;
    }

    public Object getForm() {
        return form;
    }

    public void setForm(Object form) {
        this.form = form;
    }

    public Map<String, String> getJson() {
        return json;
    }

    public void setJson(Map<String, String> json) {
        this.json = json;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Header getHeaders() {
        return headers;
    }

    public void setHeaders(Header headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "ResObj{" +
                "args=" + args +
                ", data='" + data + '\'' +
                ", files=" + files +
                ", form=" + form +
                ", json=" + json +
                ", origin='" + origin + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}


